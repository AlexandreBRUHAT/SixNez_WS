package fr.polytech.sixnez.dtos;

import java.util.List;

public class ActeurFilmDTO {
    private String id;
    private String nomPrenom;
    private List<String> metier;

    public ActeurFilmDTO() {
    }

    public ActeurFilmDTO(String id, String nomPrenom, List<String> metier) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.metier = metier;
    }

    public ActeurFilmDTO(String id, String nomPrenom) {
        this.id = id;
        this.nomPrenom = nomPrenom;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public List<String> getMetier() {
        return metier;
    }

    public void setMetier(List<String> metier) {
        this.metier = metier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
