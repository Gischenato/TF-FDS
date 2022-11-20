package com.trabfinal.negocio.servicos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;

@Service
public class ServicoAluguel {
    private IAluguelRepository aluguelRep;
    private IAeroviaRepository aeroviaRep;

    @Autowired
    public ServicoAluguel(IAluguelRepository aluguelRep, IAeroviaRepository aeroviaRep) {
        this.aluguelRep = aluguelRep;
        this.aeroviaRep = aeroviaRep;
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
        
        var alugueis = aluguelRep.findAllByAeroviaIdAndData(aerovia, dateTime);
        
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
