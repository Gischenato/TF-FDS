package com.trabfinal.adaptadores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabfinal.aplicacao.casosDeUso.VerificarPlanoDeVooUC;
import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;

@RestController
public class ControladorVoos {
    private VerificarPlanoDeVooUC verificarPlanoDeVooUC;

    @Autowired
    public ControladorVoos(VerificarPlanoDeVooUC verificarPlanoDeVooUC) {
        this.verificarPlanoDeVooUC = verificarPlanoDeVooUC;
    }

    @PostMapping("/voos/plano")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> consultaRotas(@RequestBody BodyVerificaPlanVooDTO plano) {
        String res = this.verificarPlanoDeVooUC.verificarPlanoDeVoo(plano);
        if(res.equals("OK")) return new ResponseEntity<String>(res, HttpStatus.OK);
        return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
    }

}
