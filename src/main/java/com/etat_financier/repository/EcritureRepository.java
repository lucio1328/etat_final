package com.etat_financier.repository;

import com.etat_financier.models.Ecriture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
       "WHERE tc.type LIKE :prefix% AND ex.annee = :annee")
    List<Ecriture> findByIntituleStartingWithAndAnnee(String prefix, int annee);

    @Query("SELECT e FROM Ecriture e " +
            "JOIN e.compte c " +
            "JOIN c.typeCompte tc " +
            "JOIN e.exercice ex " +
            "WHERE CAST(c.numeroCompte AS string) LIKE :compte AND ex.annee = :annee")
    List<Ecriture> findAllByCompte(String compte, int annee);

    @Query("SELECT SUM(e.montant) FROM Ecriture e JOIN e.typeOperation t WHERE t.type = :typeOperation")
    BigDecimal sumMontantByTypeOperation(@Param("typeOperation") String typeOperation);
}
