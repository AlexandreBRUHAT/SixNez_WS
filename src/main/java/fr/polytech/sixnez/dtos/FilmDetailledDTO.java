package fr.polytech.sixnez.dtos;

import java.util.List;

public class FilmDetailledDTO {

    private String title;
    private String imgURL;
    private Short annee;
    private List<ActeurFilmDTO> acteurs;
    private List<String> categories;

    public FilmDetailledDTO() {
    }

    public FilmDetailledDTO(String title, String imgURL, Short annee, List<ActeurFilmDTO> acteurs, List<String> categories) {
        this.title = title;
        this.imgURL = imgURL;
        this.annee = annee;
        this.acteurs = acteurs;
        this.categories = categories;
    }

    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public List<ActeurFilmDTO> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<ActeurFilmDTO> acteurs) {
        this.acteurs = acteurs;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
