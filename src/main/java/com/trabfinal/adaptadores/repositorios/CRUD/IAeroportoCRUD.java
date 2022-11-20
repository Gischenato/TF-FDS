package com.trabfinal.adaptadores.repositorios.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Aeroporto;

public interface IAeroportoCRUD extends JpaRepository<Aeroporto, Integer>  {
    Aeroporto findById(int id);
}
