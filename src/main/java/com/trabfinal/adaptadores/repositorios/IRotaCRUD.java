package com.trabfinal.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.trabfinal.negocio.entidades.Aeroporto;
// import com.trabfinal.negocio.entidades.Aeroporto;
// import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.entidades.Rota;

public interface IRotaCRUD extends JpaRepository<Rota, Integer> {
    List<Rota> findAll();
    Rota findById(int id);
    
    // @Query("SELECT R FROM Rota R WHERE R.origem LIKE %?1%")
    // List<Rota> findByOrigemLike(int origem);
    // // List<Rota> findByDestino(Aeroporto aeroporto);

    List<Rota> findAllByOrigemAndDestino(Aeroporto origem, Aeroporto destino);
}