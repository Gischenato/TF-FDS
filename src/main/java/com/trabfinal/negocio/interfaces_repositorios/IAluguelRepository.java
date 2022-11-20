package com.trabfinal.negocio.interfaces_repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Aluguel;

public interface IAluguelRepository {
   List<Aluguel> findAllByAeroviaIdAndData(Aerovia aeroviaId, LocalDateTime data);
   List<Aluguel> findAllByAeroviaId(Aerovia aeroviaId);   
}
