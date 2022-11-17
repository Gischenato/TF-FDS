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

    public Voo() {
    }

    public Voo(int vooId, Rota rota, LocalDateTime data) {
        this.vooId = vooId;
        this.rota = rota;
        this.data = data;
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

    public void setId(int vooId) {
        this.vooId = vooId;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
