package com.etat_financier.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etat_financier.dto.RoeDTO;

@Service
public class RoeService {

    @Autowired
    private CalculFinancierService financierService;

    public RoeDTO calculerRoe(int annee) {
        BigDecimal resultatNet = financierService.calculerResultatNet(annee);
        BigDecimal capitauxPropres = financierService.calculerCapitauxPropres(annee);

        if (capitauxPropres.compareTo(BigDecimal.ZERO) == 0) {
            return new RoeDTO(0.0, "Capitaux propres nuls.");
        }

        BigDecimal roe = resultatNet.divide(capitauxPropres, 2, BigDecimal.ROUND_HALF_UP);
        String interpretation = interpreterRoe(roe);

        return new RoeDTO(roe.doubleValue(), interpretation);
    }

    public String interpreterRoe(BigDecimal roe) {
        if (roe.compareTo(BigDecimal.valueOf(0.10)) < 0) {
            return "Seuil bas : Rendement insuffisant pour les actionnaires.";
        } else if (roe.compareTo(BigDecimal.valueOf(0.10)) >= 0 && roe.compareTo(BigDecimal.valueOf(0.20)) <= 0) {
            return "Seuil moyen : Rendement modéré pour les actionnaires.";
        } else {
            return "Seuil élevé : Bonne rentabilité générée par les capitaux propres.";
        }
    }
}
