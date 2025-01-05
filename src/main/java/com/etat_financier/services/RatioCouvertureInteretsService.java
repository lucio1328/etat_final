package com.etat_financier.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etat_financier.dto.RatioCouvertureInteretsDTO;

@Service
public class RatioCouvertureInteretsService {

    @Autowired
    private CalculFinancierService financierService;
    
    // Méthode pour calculer le ratio de couverture des intérêts (Interest Coverage Ratio)
    public RatioCouvertureInteretsDTO calculerCouvertureInterets(int annee) {
        BigDecimal resultatExploitation = financierService.calculerResultatExploitation(annee);
        BigDecimal chargesInterets = financierService.calculerChargesFinancieres(annee);

        if (chargesInterets.compareTo(BigDecimal.ZERO) == 0) {
            return new RatioCouvertureInteretsDTO(0.0, "Pas de charges d'intérêts.");
        }

        BigDecimal ratio = resultatExploitation.divide(chargesInterets, 2, BigDecimal.ROUND_HALF_UP);
        String interpretation = interpreterCouvertureInterets(ratio);

        return new RatioCouvertureInteretsDTO(ratio.doubleValue(), interpretation);
    }

    // Méthode pour interpréter le ratio de couverture des intérêts
    public String interpreterCouvertureInterets(BigDecimal ratio) {
        if (ratio.compareTo(BigDecimal.valueOf(1.5)) < 0) {
            return "Seuil critique : Difficulté à couvrir les charges d'intérêts.";
        } else if (ratio.compareTo(BigDecimal.valueOf(1.5)) >= 0 && ratio.compareTo(BigDecimal.valueOf(3)) <= 0) {
            return "Seuil de sécurité : Capacité suffisante à couvrir les charges d'intérêts.";
        } else {
            return "Seuil confortable : Solvabilité très bonne, entreprise peut couvrir ses charges d'intérêts facilement.";
        }
    }
}
