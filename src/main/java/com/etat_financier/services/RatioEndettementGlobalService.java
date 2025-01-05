package com.etat_financier.services;

import com.etat_financier.dto.RatioEndettementGlobalDTO;
import com.etat_financier.models.Ecriture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RatioEndettementGlobalService {

    @Autowired
    private EcritureService ecritureService;

    public RatioEndettementGlobalDTO getRatioEndettementGlobal(int annee) {
        List<Ecriture> actifs = ecritureService.getEcrituresByPrefixe("Actif", annee);
        List<Ecriture> passifs = ecritureService.getEcrituresByPrefixe("Passif", annee);

        BigDecimal totalActifs = actifs.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPassifs = passifs.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalActifs.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Le total des actifs est nul pour l'année " + annee);
        }

        if (totalPassifs.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Le total des passifs est nul pour l'année " + annee);
        }

        double ratio = totalPassifs.divide(totalActifs, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String interpretation = interpretRatioEndettementGlobal(ratio);

        return new RatioEndettementGlobalDTO(ratio, interpretation);
    }

    private String interpretRatioEndettementGlobal(double ratio) {
        if (ratio > 0.7) {
            return "Le ratio d'endettement global est supérieur à 70%. Cela signifie que l'entreprise dépend fortement des financements extérieurs, augmentant ainsi le risque financier.";
        } else if (ratio >= 0.5 && ratio <= 0.7) {
            return "Le ratio d'endettement global est compris entre 50% et 70%. Cela indique une situation financière raisonnable.";
        } else {
            return "Le ratio d'endettement global est inférieur à 50%. Cela montre une structure financière équilibrée avec moins de dépendance à la dette.";
        }
    }
}
