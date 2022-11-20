package com.trabfinal.adaptadores.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabfinal.aplicacao.casosDeUso.ConsultarAeroviasUC;
import com.trabfinal.aplicacao.dtos.BodyRelatorioDTO;
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
    public ResponseEntity<Map<Integer, Boolean>> consultaRotas(@RequestBody BodySlotsDTO body) {
        Map<Integer, Boolean> res = this.consultaAeroviasUc.consultarAerovia(body.getidAerovia(), body.getdata()+" "+body.gethora());
        if(res != null) return new ResponseEntity<Map<Integer, Boolean>>(res, HttpStatus.OK);
        return new ResponseEntity<Map<Integer, Boolean>>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/aerovias/relatorio")
    @CrossOrigin(origins = "*")
    public Map<Integer, Integer> relatorio(@RequestBody BodyRelatorioDTO body) {
        return this.consultaAeroviasUc.gerarRelatorio(body.getAeroviaId(), body.getData());
    }
    
}

