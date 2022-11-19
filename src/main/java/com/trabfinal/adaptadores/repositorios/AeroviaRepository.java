package com.trabfinal.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IAeroviaCRUD;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;

@Component
public class AeroviaRepository implements IAeroviaRepository{
    private IAeroviaCRUD aeroCRUD;

    @Autowired
    public AeroviaRepository(IAeroviaCRUD aeroCRUD) {
        this.aeroCRUD = aeroCRUD;  
    }  
}