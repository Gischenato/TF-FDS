package com.trabfinal.negocio.servicos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.aplicacao.dtos.AluguelLiberarPlanoDTO;
import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;
import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.entidades.Voo;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;
import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Service
public class ServicoVoo {
    private IVooRepository vooRep;
    private IAluguelRepository aluguelRep;
    private ServicoDeCalculos calculos;
    private ServicoAluguel servAluguel;

    @Autowired
    public ServicoVoo(IVooRepository vooRep, IAluguelRepository aluguelRep, ServicoDeCalculos calculos, ServicoAluguel servAluguel){
        this.vooRep = vooRep;
        this.aluguelRep = aluguelRep;
        this.calculos = calculos;
        this.servAluguel = servAluguel;
    } 

    public List<AluguelLiberarPlanoDTO> liberaVoo(int vooId, int altitude){
        Voo voo = this.vooRep.findById(vooId);

        if(voo == null) return null;

        if(altitude < 25000 || altitude > 35000) return null;

        Set<Aerovia> aerovias = voo.getRota().getAerovias();

        int tamanhoAerovias = 0;

        for (Aerovia aerovia : aerovias) {
            tamanhoAerovias += aerovia.getDistancia();
        }

        double tempo = tamanhoAerovias / voo.getVelocidade();

        List<Aluguel> alugueis = new ArrayList<Aluguel>();

        String[] dataHora = voo.getData().toString().split("T"); 
        BodyVerificaPlanVooDTO bodyVerifica = new BodyVerificaPlanVooDTO(dataHora[0], dataHora[1].substring(0, 5), vooId, voo.getVelocidade(), altitude);
        String verifica = this.verificaPlanoDeVoo(bodyVerifica);

        if(!verifica.equals("OK")) return null;
        int cont = 0;
        for (Aerovia aerovia : aerovias) {
            double tempoNaAerovia = this.calculos.calculaTempoNaAerovia(tempo, aerovia.getDistancia(), tamanhoAerovias);
            int qtdSlots = (int) Math.ceil(tempoNaAerovia);
        
            for (int i = 0; i < qtdSlots; i++) {
                LocalDateTime data = voo.getData();
                data = data.plusHours(cont++);
                Aluguel a = this.aluguelRep.save(new Aluguel(aerovia, voo, data, altitude, voo.getVelocidade()));
                alugueis.add(a);
            }
        }

        List<AluguelLiberarPlanoDTO> alugueisDTO = new ArrayList<AluguelLiberarPlanoDTO>();
        for (Aluguel aluguel : alugueis) {
            alugueisDTO.add(new AluguelLiberarPlanoDTO(aluguel.getId(),aluguel.getAeroviaId().getId(),aluguel.getVooId().getId(),aluguel.getData().toString(),aluguel.getAltitude()));
        }
        return alugueisDTO;
    }

    public String verificaPlanoDeVoo(BodyVerificaPlanVooDTO plano){
        DateTimeFormatter formatadorDeData = DateTimeFormatter
        .ofPattern("yyyy-MM-dd");

        try {
            LocalDate.parse(plano.getData(), formatadorDeData);
        } catch (Exception e) {
            return "Erro: Tipo de data invalido, ela deve seguir o formato: yyyy-MM-dd.";
        }

        DateTimeFormatter formatadorDeHorario = DateTimeFormatter
        .ofPattern("HH:mm");

        try {
            LocalTime.parse(plano.getHorario(), formatadorDeHorario);
        } catch (Exception e) {
            return "Erro: Tipo de horario invalido, ele deve seguir o formato: HH:mm.";
        }

        Voo voo = this.vooRep.findById(plano.getVoo());

        if(voo == null) return "Erro: Voo não achado no banco de dados.";

        if(!voo.getStatus().equals("PENDENTE")) return "Erro: O plano de voo precisa estar pendente para ser verificado.";

        if(plano.getVelocidade() < 0) return "Erro: Velocidade não pode ser negativa.";

        if(plano.getAltitude() < 25000 || plano.getAltitude() > 35000) return "Erro: Altitude tem que estar entre 25000 e 35000.";

        for (Aerovia aerovia : voo.getRota().getAerovias()) {
            Map<Integer, Boolean> alugeis = servAluguel.consultarAerovia(aerovia.getId(), String.format("%s %s", plano.getData(), plano.getHorario().split(":")[0]));
            for (int altitude : alugeis.keySet()) {
                if(altitude == plano.getAltitude() && !alugeis.get(altitude)) {
                    return "Erro: Aerovia já está alugada nesse horário";
                }
            }
        }

        return "OK";
    }   
}
