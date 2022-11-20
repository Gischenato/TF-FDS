package com.trabfinal.adaptadores.repositorios.CRUD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.trabfinal.negocio.entidades.Aeroporto;
// import com.trabfinal.negocio.entidades.Aeroporto;
// import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.entidades.Rota;

public interface IRotaCRUD extends JpaRepository<Rota, Integer> {
    // List<Rota> findAll();
    Rota findById(int id);
    List<Rota> findAllByOrigemAndDestino(Aeroporto origem, Aeroporto destino);
}