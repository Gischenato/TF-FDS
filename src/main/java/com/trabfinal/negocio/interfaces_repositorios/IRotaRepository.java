package com.trabfinal.negocio.interfaces_repositorios;

import java.util.List;

import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.entidades.Rota;

public interface IRotaRepository {
    // Rota findById(int id);
    // List<Rota> findAll();
    List<Rota> findByOrigemAndDestino(Aeroporto origem, Aeroporto destino);
}
