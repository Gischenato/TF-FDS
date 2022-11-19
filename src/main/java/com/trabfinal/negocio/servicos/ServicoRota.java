package com.trabfinal.negocio.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabfinal.negocio.entidades.Aeroporto;
import com.trabfinal.negocio.entidades.Rota;
import com.trabfinal.negocio.interfaces_repositorios.IAeroportoRepository;
import com.trabfinal.negocio.interfaces_repositorios.IRotaRepository;

@Component
public class ServicoRota {
    private IRotaRepository rotaRep;
    private IAeroportoRepository aeroRep;

    @Autowired
    public ServicoRota(IRotaRepository eventoRota, IAeroportoRepository aeroRep){
        this.rotaRep = eventoRota;
        this.aeroRep = aeroRep;
    } 

    // public Rota pegaRota(int id){
    //     return rotaRep.findById(id);
    // }

    public List<Integer> consultaRotas(int idDestino1, int idDestino2){
        Aeroporto a1 = this.aeroRep.findById(idDestino1);
        Aeroporto a2 = this.aeroRep.findById(idDestino2);

        List<Rota> rotas =  this.rotaRep.findByOrigemAndDestino(a1, a2);
        List<Rota> rotas2 = this.rotaRep.findByOrigemAndDestino(a2, a1);

        for (Rota rota : rotas2) {
            rotas.add(rota);
        }
        
        List<Integer> rotasIds = rotas.stream().map((a) -> a.getId()).collect(Collectors.toList());
        return rotasIds;
    }
}