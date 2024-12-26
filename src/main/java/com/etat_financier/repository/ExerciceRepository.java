package com.etat_financier.repository;

import com.etat_financier.models.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Integer> {
}
