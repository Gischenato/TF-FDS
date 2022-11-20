package com.trabfinal.aplicacao.dtos;

public class BodyLiberaPlanVooDTO {
    private int voo; // Número do voo
    private int altitude;

    public BodyLiberaPlanVooDTO() {
    }

    public BodyLiberaPlanVooDTO(int voo, int altitude) {
        this.voo = voo;
        this.altitude = altitude;
    }

    public int getVoo() {
        return voo;
    }

    public void setVoo(int voo) {
        this.voo = voo;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
    
}
