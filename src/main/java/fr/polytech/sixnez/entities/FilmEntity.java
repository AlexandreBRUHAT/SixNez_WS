package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FILM", schema = "YQ3YWoblIF", catalog = "")
public class FilmEntity {
    private String idFilm;
    private String titre;
    private Short annee;
    private String image;

    @Id
    @Column(name = "ID_film", nullable = false, length = 10)
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "Titre", nullable = true, length = 50)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Annee", nullable = true)
    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    @Basic
    @Column(name = "Image", nullable = true, length = 200)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return Objects.equals(idFilm, that.idFilm) &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(annee, that.annee) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, titre, annee, image);
    }
}
