package com.etat_financier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etat_financier.dto.RoaDTO;
import com.etat_financier.services.RoaService;

@RestController
public class RoaController {

    @Autowired
    private RoaService roaService;

    @GetMapping("/roa")
    public RoaDTO getRoa(@RequestParam int annee) {
        return roaService.calculerRoa(annee);
    }
}
