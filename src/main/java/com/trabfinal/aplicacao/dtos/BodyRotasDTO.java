package com.trabfinal.aplicacao.dtos;

public class BodyRotasDTO {
    private int idDestino1;
    private int idDestino2;

    public BodyRotasDTO(int idDestino1, int idDestino2) {
        this.idDestino1 = idDestino1;
        this.idDestino2 = idDestino2;
    }

    public int getidDestino1() {
        return idDestino1;
    }

    public void setidDestino1(int idDestino1) {
        this.idDestino1 = idDestino1;
    }

    public int getidDestino2() {
        return idDestino2;
    }

    public void setidDestino2(int idDestino2) {
        this.idDestino2 = idDestino2;
    }
}
