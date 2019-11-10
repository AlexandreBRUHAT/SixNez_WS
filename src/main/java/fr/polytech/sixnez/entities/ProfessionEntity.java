package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROFESSION", schema = "YQ3YWoblIF", catalog = "")
@IdClass(ProfessionEntityPK.class)
public class ProfessionEntity {
    private String metier;
    private String idActeur;
    private MetierEntity metierByMetier;
    private ActeurEntity acteurByIdActeur;

    @Id
    @Column(name = "Metier", nullable = false, length = 30)
    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    @Id
    @Column(name = "ID_acteur", nullable = false, length = 10)
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
        ProfessionEntity that = (ProfessionEntity) o;
        return Objects.equals(metier, that.metier) &&
                Objects.equals(idActeur, that.idActeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metier, idActeur);
    }

    @ManyToOne
    @JoinColumn(name = "Metier", referencedColumnName = "Metier", nullable = false, insertable = false, updatable = false)
    public MetierEntity getMetierByMetier() {
        return metierByMetier;
    }

    public void setMetierByMetier(MetierEntity metierByMetier) {
        this.metierByMetier = metierByMetier;
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
