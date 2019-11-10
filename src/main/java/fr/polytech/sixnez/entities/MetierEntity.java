package fr.polytech.sixnez.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "METIER", schema = "YQ3YWoblIF", catalog = "")
public class MetierEntity {
    private String metier;

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
}
