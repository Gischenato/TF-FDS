package com.trabfinal.negocio.interfaces_repositorios;

import com.trabfinal.negocio.entidades.Voo;

public interface IVooRepository {
    Voo findById(int id);
}
