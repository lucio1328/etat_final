package com.etat_financier.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Exercice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "annee", nullable = false)
    private int annee;
    @Basic
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;
    @Basic
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercice exercice = (Exercice) o;
        return id == exercice.id && annee == exercice.annee && Objects.equals(dateDebut, exercice.dateDebut) && Objects.equals(dateFin, exercice.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, annee, dateDebut, dateFin);
    }
}
