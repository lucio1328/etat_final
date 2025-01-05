package com.etat_financier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etat_financier.dto.RoeDTO;
import com.etat_financier.services.RoeService;

@RestController
public class RoeController {

    @Autowired
    private RoeService roeService;

    @GetMapping("/roe")
    public RoeDTO getRoe(@RequestParam int annee) {
        return roeService.calculerRoe(annee);
    }
}
