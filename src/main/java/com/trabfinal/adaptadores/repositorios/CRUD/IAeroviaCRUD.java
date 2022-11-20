package com.trabfinal.adaptadores.repositorios.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Aerovia;

public interface IAeroviaCRUD extends JpaRepository<Aerovia, Integer> {
    Aerovia findById(int id);
}
