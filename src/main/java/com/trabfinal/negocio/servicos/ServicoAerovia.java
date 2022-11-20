package com.trabfinal.negocio.servicos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabfinal.negocio.entidades.Aerovia;
import com.trabfinal.negocio.entidades.Aluguel;
import com.trabfinal.negocio.interfaces_repositorios.IAeroviaRepository;
import com.trabfinal.negocio.interfaces_repositorios.IAluguelRepository;

@Service
public class ServicoAerovia {
    private IAeroviaRepository aeroviaRep;
    private IAluguelRepository aluguelRep;

    @Autowired
    public ServicoAerovia(IAeroviaRepository aeroviaRep, IAluguelRepository aluguelRep) {
        this.aeroviaRep = aeroviaRep;
        this.aluguelRep = aluguelRep;
    } 

    public Aerovia consultarAerovia(int id){
        return aeroviaRep.findById(id);
    }

    public Map<Integer, Integer> gerarRelatorio(int id, String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        TreeMap<Integer, Integer> slots = new TreeMap<Integer, Integer>();
        for(int i = 25000; i <= 35000; i+=1000) 
            slots.put(i, 0);
        for (int i = 0; i<24; i++){
            LocalDateTime dateTime = LocalDateTime.parse(data+" "+(i < 10 ? "0"+i : i), formatter);
            Aerovia aerovia = aeroviaRep.findById(id);
            var alugueis = aluguelRep.findAllByAeroviaIdAndData(aerovia, dateTime);
            for (Aluguel aluguel : alugueis) {
                int slot = aluguel.getAltitude();
                slots.put(slot, slots.get(slot)+1);
            }
        }

        for (int key : slots.keySet()) {
            slots.put(key, (int) Math.round((double) slots.get(key) / 24 * 100));
        }

        return slots;
    }
}
