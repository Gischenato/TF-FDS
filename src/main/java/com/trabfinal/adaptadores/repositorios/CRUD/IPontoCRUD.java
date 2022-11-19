package com.trabfinal.adaptadores.repositorios.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Ponto;

public interface IPontoCRUD extends JpaRepository<Ponto, Integer>{
    
}
