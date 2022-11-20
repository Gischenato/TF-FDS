package com.trabfinal.aplicacao.dtos;

public class AluguelLiberarPlanoDTO {
    private int aluguelId;
    private int aeroviaId;
    private int vooId;
    private String data;
    private int altitude;

    public AluguelLiberarPlanoDTO(int aluguelId, int aeroviaId, int vooId, String data, int altitude) {
        this.aluguelId = aluguelId;
        this.aeroviaId = aeroviaId;
        this.vooId = vooId;
        this.data = data;
        this.altitude = altitude;
    }

    public int getAluguelId() {
        return aluguelId;
    }

    public void setAluguelId(int aluguelId) {
        this.aluguelId = aluguelId;
    }

    public int getAeroviaId() {
        return aeroviaId;
    }

    public void setAeroviaId(int aeroviaId) {
        this.aeroviaId = aeroviaId;
    }

    public int getVooId() {
        return vooId;
    }

    public void setVooId(int vooId) {
        this.vooId = vooId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    
}
