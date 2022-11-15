package com.trabfinal.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.entidades.Rota;
import com.trabfinal.negocio.servicos.ServicoRota;

@Component
public class ConsultarRotasUC {
    private ServicoRota servicoRota;

    @Autowired
    public ConsultarRotasUC(ServicoRota servicoRota) {
        this.servicoRota = servicoRota;
    }
    
    public Rota consultarRota(int id){
        return servicoRota.pegaRota(id);
    }    

    public List<Integer> consultarRotaPorDestinos(int idDestino1, int idDestino2){
        return servicoRota.consultaRotas(idDestino1, idDestino2);
    }   
}