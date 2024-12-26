package com.etat_financier.repository;

import com.etat_financier.models.Ecriture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcritureRepository extends JpaRepository<Ecriture, Integer> {
}
