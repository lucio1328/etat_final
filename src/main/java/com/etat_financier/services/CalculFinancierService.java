package com.etat_financier.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etat_financier.models.Ecriture;

@Service
public class CalculFinancierService {

    @Autowired
    private EcritureService ecritureService;

    // Méthode pour calculer le chiffre d'affaires (revenus)
    public BigDecimal calculerChiffreAffaires(int annee) {
        List<Ecriture> produits = ecritureService.getEcrituresByType("Produit", annee);

        return sumEcritures(produits);
    }

    // Méthode pour calculer les capitaux propres (actif - passif)
    public BigDecimal calculerCapitauxPropres(int annee) {
        List<Ecriture> actifs = ecritureService.getEcrituresByType("Actif", annee);
        List<Ecriture> passifs = ecritureService.getEcrituresByType("Passif", annee);

        BigDecimal totalActifs = sumEcritures(actifs);
        BigDecimal totalPassifs = sumEcritures(passifs);

        return totalActifs.subtract(totalPassifs);
    }

    // Méthode pour calculer les charges d'exploitation
    public BigDecimal calculerChargesExploitation(int annee) {
        List<Ecriture> charges = ecritureService.getEcrituresByType("Charge d'exploitation", annee);

        return sumEcritures(charges);
    }

    // Méthode pour calculer le résultat d'exploitation (revenus - charges d'exploitation)
    public BigDecimal calculerResultatExploitation(int annee) {
        BigDecimal chiffreAffaires = calculerChiffreAffaires(annee);
        BigDecimal chargesExploitation = calculerChargesExploitation(annee);

        return chiffreAffaires.subtract(chargesExploitation);
    }

    // Méthode pour calculer les charges financières (exemple approximatif)
    public BigDecimal calculerChargesFinancieres(int annee) {
        List<Ecriture> chargesFinancieres = ecritureService.getEcrituresByType("Charge financière", annee);

        return sumEcritures(chargesFinancieres);
    }

    // Méthode pour calculer les impôts (20% des revenus)
    public BigDecimal calculerImpots(int annee) {
        BigDecimal revenus = calculerChiffreAffaires(annee);

        return revenus.multiply(BigDecimal.valueOf(0.20));
    }

    // Méthode pour calculer le résultat net (résultat d'exploitation - charges financières - impôts)
    public BigDecimal calculerResultatNet(int annee) {
        BigDecimal resultatExploitation = calculerResultatExploitation(annee);
        BigDecimal chargesFinancieres = calculerChargesFinancieres(annee);
        BigDecimal impots = calculerImpots(annee);

        return resultatExploitation.subtract(chargesFinancieres.add(impots));
    }

    // Méthode pour sommer les montants d'une liste d'écritures
    private BigDecimal sumEcritures(List<Ecriture> ecritures) {
        return ecritures.stream()
                .map(Ecriture::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
