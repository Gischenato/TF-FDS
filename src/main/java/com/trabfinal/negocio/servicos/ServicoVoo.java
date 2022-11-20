package com.trabfinal.negocio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;
import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Service
public class ServicoVoo {
    private IVooRepository vooRep;
    private IAeroviaRepository aeroRep;

    @Autowired
    public ServicoVoo(IVooRepository vooRep, IAeroviaRepository aeroRep){
        this.vooRep = vooRep;
        this.aeroRep = aeroRep;
    } 

    public boolean liberaVoo(int vooId, int altitude){
        return true;
    }
}