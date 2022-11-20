package com.trabfinal.adaptadores.repositorios.CRUD;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.entidades.Voo;

public interface IAluguelCRUD extends JpaRepository<Aluguel, Integer>{
    List<Aluguel> findAllByAeroviaIdAndData(Aerovia aeroviaId, LocalDateTime data);
    void deleteAllByVooId(Voo id);
}
