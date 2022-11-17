package com.trabfinal.negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aerovias")
public class Aerovia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "aeroviaId", updatable = false, unique = true, nullable = false)
    private int aeroviaId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ponto_origem", referencedColumnName = "pontoId")
    private Ponto origem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ponto_destino", referencedColumnName = "pontoId")
    private Ponto destino;

    @Column(name = "distancia")
    private int distancia;

    public Aerovia() {
    }

    public Aerovia(int aeroviaId, Ponto origem, Ponto destino, String nome, String cidade, int distancia) {
        this.aeroviaId = aeroviaId;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getId() {
        return aeroviaId;
    }

    public Ponto getOrigem() {
        return origem;
    }

    public Ponto getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }

    // public Set<Rota> getRotas() {
    //     return rotas;
    // }

    public void setId(int aeroviaId) {
        this.aeroviaId = aeroviaId;
    }

    public void setOrigem(Ponto origem) {
        this.origem = origem;
    }

    public void setDestino(Ponto destino) {
        this.destino = destino;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    // public void setRota(Set<Rota> rota) {
    //     this.rotas = rota;
    // }
}
