package com.etat_financier.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Compte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_compte", nullable = false)
    private int numeroCompte;
    @Basic
    @Column(name = "classe", nullable = false, length = 50)
    private String classe;
    @Basic
    @Column(name = "intitule", nullable = false)
    private int intitule;
    @Basic
    @Column(name = "id", nullable = false)
    private int id;

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getIntitule() {
        return intitule;
    }

    public void setIntitule(int intitule) {
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return numeroCompte == compte.numeroCompte && intitule == compte.intitule && id == compte.id && Objects.equals(classe, compte.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCompte, classe, intitule, id);
    }
}
