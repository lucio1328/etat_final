package com.etat_financier.services;

import com.etat_financier.dto.CompteDeResultatDTO;
import com.etat_financier.repository.EcritureRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CompteDeResultatService {
    private final EcritureRepository ecritureRepository;

    public CompteDeResultatService(EcritureRepository ecritureRepository) {
        this.ecritureRepository = ecritureRepository;
    }

    public CompteDeResultatDTO calculerCompteDeResultat() {
        BigDecimal totalRevenus = ecritureRepository.sumMontantByTypeOperation("revenu");
        BigDecimal totalChargesExploitation = ecritureRepository.sumMontantByTypeOperation("charge_exploitation");
        BigDecimal resultatExploitation = totalRevenus.subtract(totalChargesExploitation);

        BigDecimal totalChargesFinancieres = ecritureRepository.sumMontantByTypeOperation("charge_financiere");
        BigDecimal totalImpots = ecritureRepository.sumMontantByTypeOperation("impot");
        BigDecimal resultatNet = resultatExploitation.subtract(totalChargesFinancieres).subtract(totalImpots);

        BigDecimal margeNette = totalRevenus.compareTo(BigDecimal.ZERO) > 0 ?
                resultatNet.divide(totalRevenus, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)) :
                BigDecimal.ZERO;

        CompteDeResultatDTO compteDeResultat = new CompteDeResultatDTO();
        compteDeResultat.setTotalRevenus(totalRevenus);
        compteDeResultat.setTotalChargesExploitation(totalChargesExploitation);
        compteDeResultat.setResultatExploitation(resultatExploitation);
        compteDeResultat.setTotalChargesFinancieres(totalChargesFinancieres);
        compteDeResultat.setTotalImpots(totalImpots);
        compteDeResultat.setResultatNet(resultatNet);
        compteDeResultat.setMargeNette(margeNette);

        return compteDeResultat;
    }
}
