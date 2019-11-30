package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CATEGORIE", schema = "YQ3YWoblIF")
@IdClass(CategorieEntityPK.class)
public class CategorieEntity {
    private String idFilm;
    private String genre;
    private FilmEntity filmByIdFilm;
    private GenreEntity genreByGenre;

    @Id
    @Column(name = "sixnez", nullable = false, length = 10)
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "Genre", nullable = false, length = 20)
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
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(idFilm, that.idFilm) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, genre);
    }

    @ManyToOne
    @JoinColumn(name = "ID_film", referencedColumnName = "ID_film", nullable = false, insertable = false, updatable = false)
    public FilmEntity getFilmByIdFilm() {
        return filmByIdFilm;
    }

    public void setFilmByIdFilm(FilmEntity filmByIdFilm) {
        this.filmByIdFilm = filmByIdFilm;
    }

    @ManyToOne
    @JoinColumn(name = "Genre", referencedColumnName = "Genre", nullable = false, insertable = false, updatable = false)
    public GenreEntity getGenreByGenre() {
        return genreByGenre;
    }

    public void setGenreByGenre(GenreEntity genreByGenre) {
        this.genreByGenre = genreByGenre;
    }
}
