package com.trabfinal.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCalculos {

    @Autowired
    public ServicoDeCalculos(){
    }

    public double calculaTempoNaAerovia(double tempoTotal, double tamanhoAerovia, double tamanhoTotal){
        double porcentagemDoTamanhoTotal = (tamanhoAerovia * 100) / tamanhoTotal;
        double tempoNaAerovia = tempoTotal * (porcentagemDoTamanhoTotal / 100);

        return tempoNaAerovia;
    }
}
