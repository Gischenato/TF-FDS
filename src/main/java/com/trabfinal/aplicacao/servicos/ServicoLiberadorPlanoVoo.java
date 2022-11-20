package com.trabfinal.aplicacao.servicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class ServicoLiberadorPlanoVoo {
    private IVooRepository vooRep;
    private IAluguelRepository aluguelRep;
    private ServicoDeCalculos calculos;
    private ServicoVerificadorPlanoVoo serVerVoo;

    @Autowired
    public ServicoLiberadorPlanoVoo(IVooRepository vooRep, IAluguelRepository aluguelRep, ServicoDeCalculos calculos, ServicoVerificadorPlanoVoo serVerVoo){
        this.vooRep = vooRep;
        this.aluguelRep = aluguelRep;
        this.calculos = calculos;
        this.serVerVoo = serVerVoo;
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
        String verifica = this.serVerVoo.verificaPlanoDeVoo(bodyVerifica);

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
}
