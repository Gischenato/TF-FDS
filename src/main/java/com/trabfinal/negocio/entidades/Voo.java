package com.trabfinal.negocio.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voos")
public class Voo {
    
    @Id
    @Column(name = "vooId", updatable = false, unique = true, nullable = false)
    private int vooId;

    @ManyToOne
    @JoinColumn(name = "rotaId")
    private Rota rota;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "status", nullable = false)
    private String status;

    public Voo() {
    }

    public Voo(int vooId, Rota rota, LocalDateTime data, String status) {
        this.vooId = vooId;
        this.rota = rota;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return vooId;
    }

    public Rota getRota() {
        return rota;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int vooId) {
        this.vooId = vooId;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
