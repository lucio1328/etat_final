package com.etat_financier.dto;

public class RatioCouvertureInteretsDTO {
    private Double ratio;
    private String interpretation;

    // Constructeur
    public RatioCouvertureInteretsDTO(Double ratio, String interpretation) {
        this.ratio = ratio;
        this.interpretation = interpretation;
    }

    // Getters et Setters
    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
