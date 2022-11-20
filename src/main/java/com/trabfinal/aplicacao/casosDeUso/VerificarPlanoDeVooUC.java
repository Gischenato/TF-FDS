package com.trabfinal.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;
import com.trabfinal.aplicacao.servicos.ServicoVerificadorPlanoVoo;

@Component
public class VerificarPlanoDeVooUC {
    private ServicoVerificadorPlanoVoo servicoVerificadorVoo;

    @Autowired
    public VerificarPlanoDeVooUC(ServicoVerificadorPlanoVoo servicoVerificadorVoo) {
        this.servicoVerificadorVoo = servicoVerificadorVoo;
    }

    public String verificarPlanoDeVoo(BodyVerificaPlanVooDTO plano){
        return servicoVerificadorVoo.verificaPlanoDeVoo(plano);
    }   
}
