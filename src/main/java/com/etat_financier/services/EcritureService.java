package com.etat_financier.services;

import com.etat_financier.models.Ecriture;
import com.etat_financier.repository.EcritureRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EcritureService {
    private final EcritureRepository ecritureRepository;

    public EcritureService(EcritureRepository ecritureRepository) {
        this.ecritureRepository = ecritureRepository;
    }

    public List<Ecriture> getEcrituresByType(String type, int annee) {
        return ecritureRepository.findAllByCompteType(type, annee);
    }

    public List<Ecriture> getEcrituresByCompte(String compte, int annee) {
        return ecritureRepository.findAllByCompteType(compte, annee);
    }

    public List<Ecriture> getEcrituresByPrefixe(String prefix, int annee) {
        return ecritureRepository.findByIntituleStartingWithAndAnnee(prefix, annee);
    }

    public BigDecimal getTotalActifs(int annee) {
        List<Ecriture> actifs = getEcrituresByType("Actif", annee);
        return actifs.stream()
                     .map(Ecriture::getMontant)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}