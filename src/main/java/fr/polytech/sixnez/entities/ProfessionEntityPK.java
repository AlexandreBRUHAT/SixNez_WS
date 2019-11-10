package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProfessionEntityPK implements Serializable {
    private String metier;
    private String idActeur;

    @Column(name = "Metier", nullable = false, length = 30)
    @Id
    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    @Column(name = "ID_acteur", nullable = false, length = 10)
    @Id
    public String getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(String idActeur) {
        this.idActeur = idActeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionEntityPK that = (ProfessionEntityPK) o;
        return Objects.equals(metier, that.metier) &&
                Objects.equals(idActeur, that.idActeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metier, idActeur);
    }
}
