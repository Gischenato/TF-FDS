package com.trabfinal.adaptadores.repositorios.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Voo;

public interface IVooCRUD extends JpaRepository<Voo, Integer>{
    Voo cancelFlight(int id);
}
