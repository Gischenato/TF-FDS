package com.trabfinal.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IAluguelCRUD;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;

@Component
public class AluguelRepository implements IAluguelRepository{
    private IAluguelCRUD aluguelCRUD;

    @Autowired
    public AluguelRepository(IAluguelCRUD aluguelCRUD) {
        this.aluguelCRUD = aluguelCRUD;  
    }  
}
