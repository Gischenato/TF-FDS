package com.trabfinal.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.interfaces_repositorios.IAeroportoRepository;

@Component
public class AeroportoRepository implements IAeroportoRepository{
    private IAeroportoCRUD aeroCRUD;

    @Autowired
    public AeroportoRepository(IAeroportoCRUD aeroCRUD) {
        this.aeroCRUD = aeroCRUD;  
    }  

    public Aeroporto findById(int id) {
        return this.aeroCRUD.findById(id);
    }

    public List<Aeroporto> findAll() {
        return this.aeroCRUD.findAll();
    }
}
