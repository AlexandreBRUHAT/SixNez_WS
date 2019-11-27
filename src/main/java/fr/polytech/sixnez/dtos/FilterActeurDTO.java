package fr.polytech.sixnez.dtos;

import java.util.List;

public class FilterActeurDTO implements FilterDTO {

    private String likeNom;
    private String metier;

    public FilterActeurDTO() {
    }

    public FilterActeurDTO(String likeNom, String metier) {
        this.likeNom = likeNom;
        this.metier = metier;
    }

    public String getLikeNom() {
        return likeNom;
    }

    public void setLikeNom(String likeNom) {
        this.likeNom = likeNom;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }
}
