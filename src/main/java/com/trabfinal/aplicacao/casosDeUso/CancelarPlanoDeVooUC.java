package com.trabfinal.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import com.trabfinal.negocio.entidades.Rota;
import com.trabfinal.negocio.servicos.ServicoVoo;

@Component
public class CancelarPlanoDeVooUC {
    private ServicoVoo servicoVoo;

    @Autowired
    public ConsultarRotasUC(ServicoVoo servicoVoo) {
        this.servicoVoo = servicoRota;
    }
    
    // public Rota consultarRota(int id){
    //     return servicoRota.pegaRota(id);
    // }    

    public Voo cancelarPlanoDeVoo(int idVoo){
        return servicoVoo.cancelarPlanoDeVoo(id);
    }   
}