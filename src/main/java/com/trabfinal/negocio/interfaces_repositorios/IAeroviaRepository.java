package com.trabfinal.negocio.interfaces_repositorios;

import com.trabfinal.negocio.entidades.Aerovia;

public interface IAeroviaRepository {
    Aerovia findById(int id);
}
