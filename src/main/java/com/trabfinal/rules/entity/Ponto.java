package com.trabfinal.rules.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pontos")
public class Ponto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pontoId", updatable = false, unique = true, nullable = false)
    private int pontoId;

    private float latitude;
    private float longitude;

    public Ponto() {
    }

    public Ponto(int pontoId, float latitude, float longitude) {
        this.pontoId = pontoId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return pontoId;
    }
    
    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setId(int pontoId) {
        this.pontoId = pontoId;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
