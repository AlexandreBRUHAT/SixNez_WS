package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "GENRE", schema = "YQ3YWoblIF", catalog = "")
public class GenreEntity {
    private String genre;

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
        GenreEntity that = (GenreEntity) o;
        return Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre);
    }
}
