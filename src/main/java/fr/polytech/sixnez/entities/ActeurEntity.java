package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACTEUR", schema = "YQ3YWoblIF", catalog = "")
public class ActeurEntity {
    private String idActeur;
    private String nomPrenom;
    private Short naissance;
    private Short mort;

    @Id
    @Column(name = "ID_acteur", nullable = false, length = 10)
    public String getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(String idActeur) {
        this.idActeur = idActeur;
    }

    @Basic
    @Column(name = "Nom_Prenom", nullable = false, length = 50)
    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    @Basic
    @Column(name = "Naissance", nullable = true)
    public Short getNaissance() {
        return naissance;
    }

    public void setNaissance(Short naissance) {
        this.naissance = naissance;
    }

    @Basic
    @Column(name = "Mort", nullable = true)
    public Short getMort() {
        return mort;
    }

    public void setMort(Short mort) {
        this.mort = mort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActeurEntity that = (ActeurEntity) o;
        return Objects.equals(idActeur, that.idActeur) &&
                Objects.equals(nomPrenom, that.nomPrenom) &&
                Objects.equals(naissance, that.naissance) &&
                Objects.equals(mort, that.mort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActeur, nomPrenom, naissance, mort);
    }
}
