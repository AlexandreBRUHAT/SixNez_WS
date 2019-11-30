package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "FILM", schema = "sixnez", catalog = "")
public class FilmEntity {
    private String idFilm;
    private String titre;
    private Short annee;
    private String image;
    private Collection<CategorieEntity> categoriesByIdFilm;
    private Collection<RoleEntity> rolesByIdFilm;

    @Id
    @Column(name = "ID_film" , insertable=false, updatable=false)
    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Annee")
    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    @Basic
    @Column(name = "Image")
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
        FilmEntity entity = (FilmEntity) o;
        return Objects.equals(idFilm, entity.idFilm) &&
                Objects.equals(titre, entity.titre) &&
                Objects.equals(annee, entity.annee) &&
                Objects.equals(image, entity.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, titre, annee, image);
    }

    @OneToMany(mappedBy = "filmByIdFilm")
    public Collection<CategorieEntity> getCategoriesByIdFilm() {
        return categoriesByIdFilm;
    }

    public void setCategoriesByIdFilm(Collection<CategorieEntity> categoriesByIdFilm) {
        this.categoriesByIdFilm = categoriesByIdFilm;
    }

    @OneToMany(mappedBy = "filmByIdFilm")
    public Collection<RoleEntity> getRolesByIdFilm() {
        return rolesByIdFilm;
    }

    public void setRolesByIdFilm(Collection<RoleEntity> rolesByIdFilm) {
        this.rolesByIdFilm = rolesByIdFilm;
    }
}
