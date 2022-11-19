package com.trabfinal.adaptadores.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabfinal.aplicacao.casosDeUso.ConsultarAeroviasUC;
import com.trabfinal.aplicacao.dtos.BodySlotsDTO;


@RestController
public class ControladorAerovias {
    private ConsultarAeroviasUC consultaAeroviasUc;
    
    @Autowired
    public ControladorAerovias(ConsultarAeroviasUC consultaAeroviasUc) {
        this.consultaAeroviasUc = consultaAeroviasUc;
    }
    
    @GetMapping("/aerovias/slots")
    @CrossOrigin(origins = "*")
    public Map<Integer, Boolean> consultaRotas(@RequestBody BodySlotsDTO body) {
        return this.consultaAeroviasUc.consultarAerovia(body.getidAerovia(), body.getdata()+" "+body.gethora());
    }
    
}

