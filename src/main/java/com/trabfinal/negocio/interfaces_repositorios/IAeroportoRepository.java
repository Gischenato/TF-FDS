package com.trabfinal.negocio.interfaces_repositorios;

import java.util.List;

import com.trabfinal.negocio.entidades.Aeroporto;

public interface IAeroportoRepository {
    Aeroporto getAeroporto(int id);
    List<Aeroporto> listAeroportos();
}
