package com.etat_financier.dto;

public class RoeDTO {

    private double roe;
    private String interpretation;

    public RoeDTO(double roe, String interpretation) {
        this.roe = roe;
        this.interpretation = interpretation;
    }

    public double getRoe() {
        return roe;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
