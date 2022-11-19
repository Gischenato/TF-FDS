package com.trabfinal.negocio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Component
public class ServicoVoo {
    private IVooRepository vooRep;

    @Autowired
    public ServicoVoo(IVooRepository vooRep){
        this.vooRep = vooRep;
    }

    public Voo cancelarPlanoDeVoo(int idVoo){
        return this.vooRep.cancelarPlanoDeVoo(id);
    }
}