package com.trabfinal.adaptadores.repositorios.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Aluguel;

public interface IAluguelCRUD extends JpaRepository<Aluguel, Integer>{
    
}
