package com.etat_financier.repository;

import com.etat_financier.models.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer> {
}
