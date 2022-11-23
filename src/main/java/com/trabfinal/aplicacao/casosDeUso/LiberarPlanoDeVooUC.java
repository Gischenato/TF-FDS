package com.trabfinal.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.aplicacao.dtos.AluguelLiberarPlanoDTO;
import com.trabfinal.negocio.servicos.ServicoVoo;

@Component
public class LiberarPlanoDeVooUC {
    private ServicoVoo servicoVoo;

    @Autowired
    public LiberarPlanoDeVooUC(ServicoVoo servicoVoo) {
        this.servicoVoo = servicoVoo;
    }

    public List<AluguelLiberarPlanoDTO> liberarPlanoDeVoo(int vooId, int altitude){
        return this.servicoVoo.liberaVoo(vooId, altitude);
    }   
}
