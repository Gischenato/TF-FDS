package com.trabfinal.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;
import com.trabfinal.negocio.servicos.ServicoVoo;

@Component
public class VerificarPlanoDeVooUC {
    private ServicoVoo servicoVoo;

    @Autowired
    public VerificarPlanoDeVooUC(ServicoVoo servicoVerificadorVoo) {
        this.servicoVoo = servicoVerificadorVoo;
    }

    public String verificarPlanoDeVoo(BodyVerificaPlanVooDTO plano){
        return servicoVoo.verificaPlanoDeVoo(plano);
    }   
}
