package fr.polytech.sixnez.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "METIER", schema = "sixnez", catalog = "")
public class MetierEntity {
    private String metier;
    private Collection<ProfessionEntity> professionsByMetier;

    @Id
    @Column(name = "Metier", nullable = false, length = 30)
    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetierEntity that = (MetierEntity) o;
        return Objects.equals(metier, that.metier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metier);
    }

    @OneToMany(mappedBy = "metierByMetier")
    public Collection<ProfessionEntity> getProfessionsByMetier() {
        return professionsByMetier;
    }

    public void setProfessionsByMetier(Collection<ProfessionEntity> professionsByMetier) {
        this.professionsByMetier = professionsByMetier;
    }
}
