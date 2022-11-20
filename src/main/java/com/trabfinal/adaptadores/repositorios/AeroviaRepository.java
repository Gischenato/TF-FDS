package com.trabfinal.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IAeroviaCRUD;
import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;

@Component
public class AeroviaRepository implements IAeroviaRepository{
    private IAeroviaCRUD aeroviaCRUD;

    @Autowired
    public AeroviaRepository(IAeroviaCRUD aeroviaCRUD) {
        this.aeroviaCRUD = aeroviaCRUD;  
    }

    @Override
    public Aerovia findById(int id) {
        return aeroviaCRUD.findById(id);
    }
}