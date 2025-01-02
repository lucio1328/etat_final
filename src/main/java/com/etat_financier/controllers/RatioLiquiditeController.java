package com.etat_financier.controllers;

import com.etat_financier.dto.RatioDeLiquiditeDTO;
import com.etat_financier.services.RatioDeLiquiditeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatioLiquiditeController {

    private final RatioDeLiquiditeService ratioService;

    public RatioLiquiditeController(RatioDeLiquiditeService ratioService) {
        this.ratioService = ratioService;
    }

    @GetMapping("/ratio_de_liquidite_generale")
    public RatioDeLiquiditeDTO getRatioDeLiquiditeGenerale(@RequestParam int annee) {
        return ratioService.getRatioDeLiquiditeGeneraleAvecInterpretation(annee);
    }

    @GetMapping("/ratio_de_liquidite_reduite")
    public RatioDeLiquiditeDTO getRatioDeLiquiditeReduite(@RequestParam int annee) {
        return ratioService.getRatioDeLiquiditeReduite(annee);
    }
}
