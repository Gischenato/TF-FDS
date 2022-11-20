package com.trabfinal.adaptadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabfinal.aplicacao.casosDeUso.LiberarPlanoDeVooUC;
import com.trabfinal.aplicacao.casosDeUso.CancelarPlanoDeVooUC;
import com.trabfinal.aplicacao.casosDeUso.VerificarPlanoDeVooUC;
import com.trabfinal.aplicacao.dtos.AluguelLiberarPlanoDTO;
import com.trabfinal.aplicacao.dtos.BodyLiberaPlanVooDTO;
import com.trabfinal.aplicacao.dtos.BodyVerificaPlanVooDTO;
@RestController
public class ControladorVoos {
    private VerificarPlanoDeVooUC verificarPlanoDeVooUC;
    private LiberarPlanoDeVooUC liberarPlanoDeVooUC;
    private CancelarPlanoDeVooUC cancelarPlanoDeVooUC;
    
    @Autowired
    public ControladorVoos(VerificarPlanoDeVooUC verificarPlanoDeVooUC, LiberarPlanoDeVooUC liberarPlanoDeVooUC, CancelarPlanoDeVooUC cancelarPlanoDeVooUC) {
        this.verificarPlanoDeVooUC = verificarPlanoDeVooUC;
        this.cancelarPlanoDeVooUC = cancelarPlanoDeVooUC;
        this.liberarPlanoDeVooUC = liberarPlanoDeVooUC;
    }

    @PostMapping("/voos/plano/verificar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> verificaPlano(@RequestBody BodyVerificaPlanVooDTO plano) {
        String res = this.verificarPlanoDeVooUC.verificarPlanoDeVoo(plano);
        if(res.equals("OK")) return new ResponseEntity<String>(res, HttpStatus.OK);
        return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/voos/plano/liberar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<AluguelLiberarPlanoDTO>> liberaPlano(@RequestBody BodyLiberaPlanVooDTO plano) {
        List<AluguelLiberarPlanoDTO> res = this.liberarPlanoDeVooUC.liberarPlanoDeVoo(plano.getVoo(), plano.getAltitude());
        if(res != null) return new ResponseEntity<List<AluguelLiberarPlanoDTO>>(res, HttpStatus.OK);
        return new ResponseEntity<List<AluguelLiberarPlanoDTO>>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/voos/cancelar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> cancelarVoo(@RequestParam int id) {
        String res = this.cancelarPlanoDeVooUC.cancelarPlanoDeVoo(id);
        if(res.equals("Voo cancelado com sucesso")) return new ResponseEntity<>(res, HttpStatus.OK);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
    
    

}
