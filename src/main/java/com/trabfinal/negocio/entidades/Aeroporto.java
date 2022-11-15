package com.trabfinal.negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aeroportos")
public class Aeroporto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "aeroportoId", updatable = false, unique = true, nullable = false)
    private int aeroportoId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ponto", referencedColumnName = "pontoId")
    private Ponto ponto;

    @Column(name = "nome", updatable = false, unique = true, nullable = false)
    private String nome;

    @Column(name = "cidade", updatable = false, unique = true, nullable = false)
    private String cidade;

    public Aeroporto() {
    }

    public Aeroporto(int aeroportoId, Ponto ponto, String nome, String cidade) {
        this.aeroportoId = aeroportoId;
        this.ponto = ponto;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getId() {
        return aeroportoId;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setId(int aeroportoId) {
        this.aeroportoId = aeroportoId;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
