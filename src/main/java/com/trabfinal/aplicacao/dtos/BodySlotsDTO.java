package com.trabfinal.aplicacao.dtos;

public class BodySlotsDTO {
    private int idAerovia;
    private String data;
    private String hora;

    public BodySlotsDTO(int idAerovia, String data, String hora) {
        this.idAerovia = idAerovia;
        this.data = data;
        this.hora = hora;
    }

    public int getidAerovia() {
        return idAerovia;
    }
    
    public String getdata() {
        return data;
    }

    public String gethora() {
        return hora;
    }

    public void setidAerovia(int idAerovia) {
        this.idAerovia = idAerovia;
    }

    public void setdata(String data) {
        this.data = data;
    }

    public void sethora(String hora) {
        this.hora = hora;
    }
}
