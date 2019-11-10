package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CategorieEntityPK implements Serializable {
    private String idFilm;
    private String genre;

    @Column(name = "ID_film", nullable = false, length = 10)
    @Id
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Column(name = "Genre", nullable = false, length = 20)
    @Id
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntityPK that = (CategorieEntityPK) o;
        return Objects.equals(idFilm, that.idFilm) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, genre);
    }
}
