package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoleEntityPK implements Serializable {
    private String idFilm;
    private String idActeur;

    @Column(name = "ID_film", nullable = false, length = 10)
    @Id
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
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
        RoleEntityPK that = (RoleEntityPK) o;
        return Objects.equals(idFilm, that.idFilm) &&
                Objects.equals(idActeur, that.idActeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idActeur);
    }
}
