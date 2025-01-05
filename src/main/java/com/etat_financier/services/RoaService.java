package com.etat_financier.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etat_financier.dto.RoaDTO;

@Service
public class RoaService {

    @Autowired
    private CalculFinancierService financierService;
    
    @Autowired
    private EcritureService ecritureService;

    public RoaDTO calculerRoa(int annee) {
        BigDecimal resultatNet = financierService.calculerResultatNet(annee);
        BigDecimal totalActifs = ecritureService.getTotalActifs(annee);

        if (totalActifs.compareTo(BigDecimal.ZERO) == 0) {
            return new RoaDTO(0.0, "Total des actifs nul.");
        }

        BigDecimal roa = resultatNet.divide(totalActifs, 2, BigDecimal.ROUND_HALF_UP);
        String interpretation = interpreterRoa(roa);

        return new RoaDTO(roa.doubleValue(), interpretation);
    }

    public String interpreterRoa(BigDecimal roa) {
        if (roa.compareTo(BigDecimal.valueOf(0.05)) < 0) {
            return "Seuil bas : Mauvaise utilisation des actifs.";
        } else if (roa.compareTo(BigDecimal.valueOf(0.05)) >= 0 && roa.compareTo(BigDecimal.valueOf(0.10)) <= 0) {
            return "Seuil moyen : Utilisation modérée des actifs.";
        } else {
            return "Seuil élevé : Bonne utilisation des actifs pour générer des profits.";
        }
    }
}
