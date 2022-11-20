package com.trabfinal.aplicacao.dtos;

public class BodyVerificaPlanVooDTO {
    private String data;
    private String horario;
    private int voo; // Número do voo
    private int RotaId;
    private int velocidade;
    private int altitude;

    public BodyVerificaPlanVooDTO() {
    }

    public BodyVerificaPlanVooDTO(String data, String horario, int voo, int RotaId, int velocidade, int altitude) {
        this.data = data;
        this.horario = horario;
        this.voo = voo;
        this.RotaId = RotaId;
        this.velocidade = velocidade;
        this.altitude = altitude;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getVoo() {
        return voo;
    }

    public void setVoo(int voo) {
        this.voo = voo;
    }

    public int getRotaId() {
        return RotaId;
    }

    public void setRotaId(int rotaId) {
        RotaId = rotaId;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
