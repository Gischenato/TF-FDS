package com.trabfinal.negocio.servicos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;
import com.trabfinal.negocio.interfaces_repositorios.IVooRepository;

@Service
@Transactional
public class ServicoAluguel {
    private IAluguelRepository aluguelRep;
    private IAeroviaRepository aeroviaRep;
    private IVooRepository vooRep;

    @Autowired
    public ServicoAluguel(IAluguelRepository aluguelRep, IAeroviaRepository aeroviaRep, IVooRepository vooRep) {
        this.aluguelRep = aluguelRep;
        this.aeroviaRep = aeroviaRep;
        this.vooRep = vooRep;
    } 

    public void cancelaAluguel(int vooId){
        var voo = vooRep.findById(vooId);
        if (voo == null) throw new Error("Voo nao encontrado");
        aluguelRep.deleteAllByVooId(voo);
        voo.setStatus("CANCELADO");
    }

    public Map<Integer, Boolean> consultarAerovia(int id, String data) {
        var aerovia = aeroviaRep.findById(id);
        
        LocalDateTime dateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
            dateTime = LocalDateTime.parse(data, formatter);
        } catch(Exception e) {
            return null;
        }
        System.out.println(dateTime.toString());
        var alugueis = aluguelRep.findAllByAeroviaIdAndData(aerovia, dateTime);
        System.out.println(alugueis);

        ArrayList<Integer> altitudesOcupadas = new ArrayList<Integer>();
        for (Aluguel aluguel : alugueis)
            altitudesOcupadas.add(aluguel.getAltitude());
        
        TreeMap<Integer, Boolean> altitudesDto = new TreeMap<Integer, Boolean>();
        int[] altitudes = {25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000, 35000};
        for (int altitude : altitudes) 
            altitudesDto.put(altitude, altitudesOcupadas.contains(altitude) ? false : true);

        return altitudesDto;
    }    
}
