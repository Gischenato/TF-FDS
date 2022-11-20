package com.trabfinal.aplicacao.servicos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;
import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Voo;
import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;
import com.trabfinal.negocio.servicos.ServicoAluguel;

@Component
public class ServicoVerificadorPlanoVoo {
    private IVooRepository vooRep;
    private ServicoAluguel servAluguel;


    @Autowired
    public ServicoVerificadorPlanoVoo(IVooRepository vooRep, ServicoAluguel servAluguel) {
        this.vooRep = vooRep;
        this.servAluguel = servAluguel;
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
