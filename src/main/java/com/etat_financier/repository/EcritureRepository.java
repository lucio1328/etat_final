package com.etat_financier.repository;

import com.etat_financier.models.Ecriture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EcritureRepository extends JpaRepository<Ecriture, Integer> {
    @Query("SELECT e FROM Ecriture e " +
           "JOIN e.compte c " +
           "JOIN c.typeCompte tc " +
           "JOIN e.exercice ex " +
           "WHERE tc.type = :type AND ex.annee = :annee")
    List<Ecriture> findAllByCompteType(String type, Integer annee);

    @Query("SELECT e FROM Ecriture e " +
            "JOIN e.compte c " +
            "JOIN c.typeCompte tc " +
            "JOIN e.exercice ex " +
            "WHERE CAST(c.numeroCompte AS string) LIKE :compte AND ex.annee = :annee")
    List<Ecriture> findAllByCompte(String compte, int annee);
}
