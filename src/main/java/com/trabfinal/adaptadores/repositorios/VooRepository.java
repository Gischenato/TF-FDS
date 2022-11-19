package com.trabfinal.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IVooCRUD;
import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Component
public class VooRepository implements IVooRepository{
    private IVooCRUD vooCRUD;

    @Autowired
    public VooRepository(IVooCRUD vooCRUD) {
        this.vooCRUD = vooCRUD;  
    }  
}
