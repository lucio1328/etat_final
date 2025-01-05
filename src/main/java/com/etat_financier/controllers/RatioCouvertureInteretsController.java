package com.etat_financier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etat_financier.dto.RatioCouvertureInteretsDTO;
import com.etat_financier.services.RatioCouvertureInteretsService;

@RestController
public class RatioCouvertureInteretsController {
    @Autowired
    private RatioCouvertureInteretsService ratioCouvertureInteretsService;

    @GetMapping("/ratio_couverture_interets")
    public RatioCouvertureInteretsDTO getRatioCouvertureInterets(@RequestParam int annee) {
        return ratioCouvertureInteretsService.calculerCouvertureInterets(annee);
    }
}
