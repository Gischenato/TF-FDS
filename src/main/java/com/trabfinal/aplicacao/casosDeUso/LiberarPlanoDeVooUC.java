package com.trabfinal.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.aplicacao.dtos.AluguelLiberarPlanoDTO;
import com.trabfinal.aplicacao.servicos.ServicoLiberadorPlanoVoo;

@Component
public class LiberarPlanoDeVooUC {
    private ServicoLiberadorPlanoVoo servicoLibVoo;

    @Autowired
    public LiberarPlanoDeVooUC(ServicoLiberadorPlanoVoo servicoLibVoo) {
        this.servicoLibVoo = servicoLibVoo;
    }

    public List<AluguelLiberarPlanoDTO> liberarPlanoDeVoo(int vooId, int altitude){
        return this.servicoLibVoo.liberaVoo(vooId, altitude);
    }   
}
