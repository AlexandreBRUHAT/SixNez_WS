package fr.polytech.sixnez.dtos;

import java.util.List;

public class ActeurDetailledDTO {

    private String id;
    private String nomPrenom;
    private Short naissance;
    private Short mort;
    private List<String> metier;
    private List<FilmActeurDTO> filmDTOS;

    public ActeurDetailledDTO() {
    }

    public ActeurDetailledDTO(String id, String nomPrenom, Short naissance, Short mort, List<String> metier, List<FilmActeurDTO> filmDTOS) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.naissance = naissance;
        this.mort = mort;
        this.metier = metier;
        this.filmDTOS = filmDTOS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public Short getNaissance() {
        return naissance;
    }

    public void setNaissance(Short naissance) {
        this.naissance = naissance;
    }

    public Short getMort() {
        return mort;
    }

    public void setMort(Short mort) {
        this.mort = mort;
    }

    public List<String> getMetier() {
        return metier;
    }

    public void setMetier(List<String> metier) {
        this.metier = metier;
    }

    public List<FilmActeurDTO> getFilmDTOS() {
        return filmDTOS;
    }

    public void setFilmDTOS(List<FilmActeurDTO> filmDTOS) {
        this.filmDTOS = filmDTOS;
    }
}
