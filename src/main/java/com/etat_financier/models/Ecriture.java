package com.etat_financier.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Ecriture {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "montant", nullable = false, precision = 2)
    private BigDecimal montant;
    @Basic
    @Column(name = "date_saisie", nullable = false)
    private Date dateSaisie;
    @Basic
    @Column(name = "id_1", nullable = false)
    private int id1;
    @Basic
    @Column(name = "numero_compte", nullable = false)
    private int numeroCompte;
    @Basic
    @Column(name = "id_2", nullable = false)
    private int id2;

    @ManyToOne
    @JoinColumn(name = "id_1", referencedColumnName = "id", insertable = false, updatable = false)
    private TypeOperation typeOperation;

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    @ManyToOne
    @JoinColumn(name = "numero_compte", referencedColumnName = "numero_compte", insertable = false, updatable = false)
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "id_2", referencedColumnName = "id", insertable = false, updatable = false)
    private Exercice exercice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(Date dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public Compte getCompte() {
        return compte;
    }
    
    public void setCompte(Compte compte) {
        this.compte = compte;
    }    

    public Exercice getExercice() {
        return exercice;
    }
    
    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ecriture ecriture = (Ecriture) o;
        return id == ecriture.id && id1 == ecriture.id1 && numeroCompte == ecriture.numeroCompte && id2 == ecriture.id2 && Objects.equals(montant, ecriture.montant) && Objects.equals(dateSaisie, ecriture.dateSaisie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant, dateSaisie, id1, numeroCompte, id2);
    }
}
