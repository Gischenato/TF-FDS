package com.trabfinal.negocio.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rotas")
public class Rota {
    
    @Id
    @Column(name = "rotaId", updatable = false, unique = true, nullable = false)
    private int rotaId;

    @OneToOne
    private Aeroporto origem;

    @OneToOne
    private Aeroporto destino;

    @ManyToMany
    @JoinTable(
        name = "aerovia_rota", 
        joinColumns = @JoinColumn(name = "rotaId"), 
        inverseJoinColumns = @JoinColumn(name = "aeroviaId"))
    private Set<Aerovia> aerovias;

    public Rota() {
    }

    public Rota(int rotaId, Aeroporto origem, Aeroporto destino) {
        this.rotaId = rotaId;
        this.origem = origem;
        this.destino = destino;
    }

    public int getId() {
        return rotaId;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }
   
    public Set<Aerovia> getAerovias() {
        return aerovias;
    }

    public void setId(int rotaId) {
        this.rotaId = rotaId;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }   

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public void setAerovias(Set<Aerovia> aerovias) {
        this.aerovias = aerovias;
    }
}
