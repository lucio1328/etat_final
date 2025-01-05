package com.etat_financier.dto;

public class RatioEndettementGlobalDTO {
    private double ratio;
    private String interpretation;

    public RatioEndettementGlobalDTO(double ratio, String interpretation) {
        this.ratio = ratio;
        this.interpretation = interpretation;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
