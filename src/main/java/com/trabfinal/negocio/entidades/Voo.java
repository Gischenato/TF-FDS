package com.trabfinal.negocio.entidades;

import java.sql.Date;

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
    private Date data;

    public Voo() {
    }

    public Voo(int vooId, Rota rota, Date data) {
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

    public Date getData() {
        return data;
    }

    public void setId(int vooId) {
        this.vooId = vooId;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
