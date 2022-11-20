package com.trabfinal.negocio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Component
public class ServicoVoo {
    private IVooRepository vooRepository;

    @Autowired
    public ServicoVoo(IVooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }
}