package com.trabfinal.aplicacao.casosDeUso;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.servicos.ServicoAerovia;
import com.trabfinal.negocio.servicos.ServicoAluguel;

@Component
public class ConsultarAeroviasUC {
    private ServicoAerovia servicoAerovia;
    private ServicoAluguel servicoAluguel;

    @Autowired
    public ConsultarAeroviasUC(ServicoAerovia servicoAerovia, ServicoAluguel servicoAluguel) {
        this.servicoAerovia = servicoAerovia;
        this.servicoAluguel = servicoAluguel;
    }
    
    public Map<Integer, Boolean> consultarAerovia(int id, String data){
        return servicoAluguel.consultarAerovia(id, data);
    }

    public Map<Integer, Integer> gerarRelatorio(int id, String data) {
        return servicoAerovia.gerarRelatorio(id, data);
    }

}