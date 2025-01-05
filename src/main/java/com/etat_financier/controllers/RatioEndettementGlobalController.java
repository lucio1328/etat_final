package com.etat_financier.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etat_financier.dto.RatioEndettementGlobalDTO;
import com.etat_financier.services.RatioEndettementGlobalService;

@RestController
public class RatioEndettementGlobalController {
    private final RatioEndettementGlobalService ratioEndettementGlobalService;

    public RatioEndettementGlobalController(RatioEndettementGlobalService ratioEndettementGlobalService) {
        this.ratioEndettementGlobalService = ratioEndettementGlobalService;
    }

    @GetMapping("/ratio_endettement_global")
    public RatioEndettementGlobalDTO getRatioEndettementGlobal(@RequestParam int annee) {
        return ratioEndettementGlobalService.getRatioEndettementGlobal(annee);
    }
}
