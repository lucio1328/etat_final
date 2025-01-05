package com.etat_financier.dto;

public class RoaDTO {

    private double roa;
    private String interpretation;

    public RoaDTO(double roa, String interpretation) {
        this.roa = roa;
        this.interpretation = interpretation;
    }

    public double getRoa() {
        return roa;
    }

    public void setRoa(double roa) {
        this.roa = roa;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
