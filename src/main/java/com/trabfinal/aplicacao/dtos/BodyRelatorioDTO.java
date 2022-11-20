package com.trabfinal.aplicacao.dtos;

public class BodyRelatorioDTO {
    private int aeroviaId;
    private String data;

    public BodyRelatorioDTO(int aeroviaId, String data) {
        this.aeroviaId = aeroviaId;
        this.data = data;
    }

    public int getAeroviaId() {
        return aeroviaId;
    }

    public void setAeroviaId(int aeroviaId) {
        this.aeroviaId = aeroviaId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
