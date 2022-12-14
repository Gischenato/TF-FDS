package com.trabfinal.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IRotaCRUD;
import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.entidades.Rota;
import com.trabfinal.negocio.interfaces_repositorios.IRotaRepository;

@Component
public class RotaRepository implements IRotaRepository{
    private IRotaCRUD rotaCRUD;

    @Autowired
    public RotaRepository(IRotaCRUD rotaCRUD) {
        this.rotaCRUD = rotaCRUD;  
    }  

    public Rota findById(int id) {
        return this.rotaCRUD.findById(id);
    }

    public List<Rota> findByOrigemAndDestino(Aeroporto origem, Aeroporto destino) {
        return this.rotaCRUD.findAllByOrigemAndDestino(origem, destino);
    }

}
