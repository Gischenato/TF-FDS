package com.trabfinal.negocio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;

@Service
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
