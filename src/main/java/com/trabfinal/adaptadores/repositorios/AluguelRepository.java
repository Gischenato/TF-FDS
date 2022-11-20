package com.trabfinal.adaptadores.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.adaptadores.repositorios.CRUD.IAeroviaCRUD;
import com.trabfinal.adaptadores.repositorios.CRUD.IAluguelCRUD;
import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.entidades.Voo;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;

@Component
public class AluguelRepository implements IAluguelRepository{
    private IAluguelCRUD aluguelCRUD;

    @Autowired
    public AluguelRepository(IAluguelCRUD aluguelCRUD, IAeroviaCRUD aeroviaCRUD) {
        this.aluguelCRUD = aluguelCRUD;
    }

    @Override
    public List<Aluguel> findAllByAeroviaIdAndData(Aerovia id, LocalDateTime data) {
        return this.aluguelCRUD.findAllByAeroviaIdAndData(id, data);
    }
    
    @Override
    public List<Aluguel> findAllByAeroviaId(Aerovia id) {
        return this.aluguelCRUD.findAllByAeroviaId(id);
    }

    @Override
    public Aluguel save(Aluguel aluguel) {
        return this.aluguelCRUD.save(aluguel);
    }  
    
    @Override
    public void deleteAllByVooId(Voo id) {
        aluguelCRUD.deleteAllByVooId(id);
    } 
}
