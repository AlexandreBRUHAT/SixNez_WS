package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLE", schema = "YQ3YWoblIF", catalog = "")
@IdClass(RoleEntityPK.class)
public class RoleEntity {
    private String idFilm;
    private String idActeur;
    private Byte role;
    private FilmEntity filmByIdFilm;
    private ActeurEntity acteurByIdActeur;

    @Id
    @Column(name = "ID_film", nullable = false, length = 10)
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Id
    @Column(name = "ID_acteur", nullable = false, length = 10)
    public String getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(String idActeur) {
        this.idActeur = idActeur;
    }

    @Basic
    @Column(name = "Role", nullable = false)
    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(idFilm, that.idFilm) &&
                Objects.equals(idActeur, that.idActeur) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idActeur, role);
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
    @JoinColumn(name = "ID_acteur", referencedColumnName = "ID_acteur", nullable = false, insertable = false, updatable = false)
    public ActeurEntity getActeurByIdActeur() {
        return acteurByIdActeur;
    }

    public void setActeurByIdActeur(ActeurEntity acteurByIdActeur) {
        this.acteurByIdActeur = acteurByIdActeur;
    }
}
