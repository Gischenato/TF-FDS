package com.trabfinal.adaptadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabfinal.aplicacao.casosDeUso.ConsultarRotasUC;
import com.trabfinal.aplicacao.dtos.BodyRotasDTO;


@RestController
public class ControladorAerovias {
    private ConsultarRotasUC consultaRotasUc;
    
    @Autowired
    public ControladorAerovias(ConsultarRotasUC consultaRotasUc) {
        this.consultaRotasUc = consultaRotasUc;
    }
    
    @GetMapping("/aerovias/slots")
    @CrossOrigin(origins = "*")
    public List<Integer> consultaRotas(@RequestBody BodyRotasDTO rota) {
        return this.consultaRotasUc.consultarRotaPorDestinos(rota.getidDestino1(), rota.getidDestino2());
    }
    
}

