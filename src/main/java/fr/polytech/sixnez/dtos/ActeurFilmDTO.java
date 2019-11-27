package fr.polytech.sixnez.dtos;

import java.util.List;

public class ActeurFilmDTO {
    private String id;
    private String nomPrenom;
    private int naissance;
    private int mort;
    private List<String> metier;

    public ActeurFilmDTO() {
    }

    public ActeurFilmDTO(String id, String nomPrenom, int naissance, int mort, List<String> metier) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.naissance = naissance;
        this.mort = mort;
        this.metier = metier;
    }

    public ActeurFilmDTO(String id, String nomPrenom, int naissance, int mort) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.naissance = naissance;
        this.mort = mort;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public int getNaissance() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }

    public int getMort() {
        return mort;
    }

    public void setMort(int mort) {
        this.mort = mort;
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
