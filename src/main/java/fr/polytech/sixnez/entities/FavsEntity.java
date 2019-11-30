package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FAVS", schema = "sixnez", catalog = "")
@IdClass(FavsEntityPK.class)
public class FavsEntity {
    private String username;
    private String idFilm;

    public FavsEntity() {
    }

    @Id
    @Column(name = "username", nullable = false, length = 40)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "id_film", nullable = false, length = 10)
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavsEntity that = (FavsEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(idFilm, that.idFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, idFilm);
    }
}
