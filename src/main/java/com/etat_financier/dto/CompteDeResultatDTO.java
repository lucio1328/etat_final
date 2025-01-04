package com.etat_financier.dto;

import java.math.BigDecimal;

public class CompteDeResultatDTO {
    private BigDecimal totalRevenus;
    private BigDecimal totalChargesExploitation;
    private BigDecimal resultatExploitation;
    private BigDecimal totalChargesFinancieres;
    private BigDecimal totalImpots;
    private BigDecimal resultatNet;
    private BigDecimal margeNette;

    
    public CompteDeResultatDTO() {
    }
    public CompteDeResultatDTO(BigDecimal totalRevenus, BigDecimal totalChargesExploitation,
            BigDecimal resultatExploitation, BigDecimal totalChargesFinancieres, BigDecimal totalImpots,
            BigDecimal resultatNet, BigDecimal margeNette) {
        this.totalRevenus = totalRevenus;
        this.totalChargesExploitation = totalChargesExploitation;
        this.resultatExploitation = resultatExploitation;
        this.totalChargesFinancieres = totalChargesFinancieres;
        this.totalImpots = totalImpots;
        this.resultatNet = resultatNet;
        this.margeNette = margeNette;
    }
    public BigDecimal getTotalRevenus() {
        return totalRevenus;
    }
    public void setTotalRevenus(BigDecimal totalRevenus) {
        this.totalRevenus = totalRevenus;
    }
    public BigDecimal getTotalChargesExploitation() {
        return totalChargesExploitation;
    }
    public void setTotalChargesExploitation(BigDecimal totalChargesExploitation) {
        this.totalChargesExploitation = totalChargesExploitation;
    }
    public BigDecimal getResultatExploitation() {
        return resultatExploitation;
    }
    public void setResultatExploitation(BigDecimal resultatExploitation) {
        this.resultatExploitation = resultatExploitation;
    }
    public BigDecimal getTotalChargesFinancieres() {
        return totalChargesFinancieres;
    }
    public void setTotalChargesFinancieres(BigDecimal totalChargesFinancieres) {
        this.totalChargesFinancieres = totalChargesFinancieres;
    }
    public BigDecimal getTotalImpots() {
        return totalImpots;
    }
    public void setTotalImpots(BigDecimal totalImpots) {
        this.totalImpots = totalImpots;
    }
    public BigDecimal getResultatNet() {
        return resultatNet;
    }
    public void setResultatNet(BigDecimal resultatNet) {
        this.resultatNet = resultatNet;
    }
    public BigDecimal getMargeNette() {
        return margeNette;
    }
    public void setMargeNette(BigDecimal margeNette) {
        this.margeNette = margeNette;
    }

}
