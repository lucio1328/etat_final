package com.etat_financier.services;

import com.etat_financier.dto.RatioDeLiquiditeDTO;
import com.etat_financier.models.Ecriture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RatioDeLiquiditeService {

    @Autowired
    private EcritureService ecritureService;

    public RatioDeLiquiditeDTO getRatioDeLiquiditeGeneraleAvecInterpretation(int annee) {
        List<Ecriture> actifsCourants = ecritureService.getEcrituresByType("Actif courant", annee);
        List<Ecriture> passifsCourants = ecritureService.getEcrituresByType("Passif courant", annee);

        BigDecimal totalActifsCourants = actifsCourants.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPassifsCourants = passifsCourants.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPassifsCourants.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Le total des passifs courants est nul pour l'année " + annee);
        }

        double ratio = totalActifsCourants.divide(totalPassifsCourants, 2, BigDecimal.ROUND_HALF_UP).doubleValue();

        String interpretation = interpretRatioDeLiquiditeGenerale(ratio);

        return new RatioDeLiquiditeDTO(ratio, interpretation);
    }

    public String interpretRatioDeLiquiditeGenerale(double ratio) {
        if (ratio < 1.0) {
            return "Le ratio de liquidité générale est inférieur à 1. Cela signifie que l'entreprise pourrait avoir des difficultés à honorer ses dettes à court terme.";
        } else if (ratio >= 1.0 && ratio <= 2.0) {
            return "Le ratio de liquidité générale est compris entre 1 et 2. Cela indique une situation financière saine avec une capacité adéquate à couvrir les dettes à court terme.";
        } else {
            return "Le ratio de liquidité générale est supérieur à 2. Cela pourrait indiquer une gestion prudente des liquidités ou une utilisation inefficace des ressources.";
        }
    }

    public RatioDeLiquiditeDTO getRatioDeLiquiditeReduite(int annee) {
        List<Ecriture> actifsCourants = ecritureService.getEcrituresByType("Actif courant", annee);

        List<Ecriture> stocks = ecritureService.getEcrituresByCompte("3%", annee);

        List<Ecriture> passifsCourants = ecritureService.getEcrituresByType("Passif courant", annee);

        BigDecimal totalActifsCourants = actifsCourants.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalStocks = stocks.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPassifsCourants = passifsCourants.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalPassifsCourants.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Le total des passifs courants est nul pour l'année " + annee);
        }

        BigDecimal liquiditeReduite = totalActifsCourants.subtract(totalStocks);

        double ratio = liquiditeReduite.divide(totalPassifsCourants, 2, BigDecimal.ROUND_HALF_UP).doubleValue();

        String interpretation = interpretRatioDeLiquiditeReduite(ratio);

        return new RatioDeLiquiditeDTO(ratio, interpretation);
    }

    private String interpretRatioDeLiquiditeReduite(double ratio) {
        if (ratio >= 1.5) {
            return "La liquidité réduite est satisfaisante.";
        } else if (ratio >= 1) {
            return "La liquidité réduite est acceptable, mais pourrait être améliorée.";
        } else {
            return "La liquidité réduite est insuffisante.";
        }
    }
}
