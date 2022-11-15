package com.trabfinal.rules.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluguel {
    @Id
    private int aluguelId;
    
    @ManyToOne
    @JoinColumn(name = "aeroviaId")
    private Aerovia aeroviaId;

    @ManyToOne
    @JoinColumn(name = "vooId")
    private Voo vooId;

    @Column(name = "data", nullable = false)
    private Date data;
    
    @Column(name = "altitude", nullable = false)
    private int altitude;
    
    public Aluguel() {
    }

    public Aluguel(int aluguelId, Aerovia aeroviaId, Voo vooId, Date data, int altitude, int velocidade) {
        this.aluguelId = aluguelId;
        this.aeroviaId = aeroviaId;
        this.vooId = vooId;
        this.data = data;
        this.altitude = altitude;
    }

    public int getId() {
        return aluguelId;
    }

    public Aerovia getAeroviaId() {
        return aeroviaId;
    }

    public Voo getVooId() {
        return vooId;
    }

    public Date getData() {
        return data;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setId(int aluguelId) {
        this.aluguelId = aluguelId;
    }

    public void setAeroviaId(Aerovia aeroviaId) {
        this.aeroviaId = aeroviaId;
    }

    public void setVooId(Voo vooId) {
        this.vooId = vooId;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

}
