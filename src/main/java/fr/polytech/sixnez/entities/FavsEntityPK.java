package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FavsEntityPK implements Serializable {
    private String username;
    private String idFilm;

    @Column(name = "username", nullable = false, length = 40)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "id_film", nullable = false, length = 10)
    @Id
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
        FavsEntityPK that = (FavsEntityPK) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(idFilm, that.idFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, idFilm);
    }
}
