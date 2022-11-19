package com.trabfinal.negocio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;

@Component
public class ServicoAerovia {
    private IAeroviaRepository aeroviaRep;

    @Autowired
    public ServicoAerovia(IAeroviaRepository aeroviaRep){
        this.aeroviaRep = aeroviaRep;
    } 

    public Aerovia consultarAerovia(int id){
        return aeroviaRep.findById(id);
    }
}
