package com.etat_financier.controllers;

import com.etat_financier.dto.CompteDeResultatDTO;
import com.etat_financier.services.CompteDeResultatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compte-de-resultat")
public class CompteDeResultatController {
    private final CompteDeResultatService compteDeResultatService;

    public CompteDeResultatController(CompteDeResultatService compteDeResultatService) {
        this.compteDeResultatService = compteDeResultatService;
    }

    @GetMapping
    public CompteDeResultatDTO getCompteDeResultat() {
        return compteDeResultatService.calculerCompteDeResultat();
    }
}
