package com.trabfinal.adaptadores.repositorios.CRUD;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Aeroporto;

public interface IAeroportoCRUD extends JpaRepository<Aeroporto, Integer>  {
    // List<Aeroporto> findAll();
    Aeroporto findById(int id);
}
