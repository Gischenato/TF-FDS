package com.trabfinal.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IPontoCRUD;
import com.trabfinal.negocio.interfaces_repositorios.IPontoRepository;

@Component
public class PontoRepository implements IPontoRepository{
    private IPontoCRUD pontoCRUD;

    @Autowired
    public PontoRepository(IPontoCRUD pontoCRUD) {
        this.pontoCRUD = pontoCRUD;  
    }  
}
