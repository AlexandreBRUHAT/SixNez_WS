package fr.polytech.sixnez.dtos;

import java.util.List;

public class FilmDetailledDTO {

    private String title;
    private String imgURL;
    private List<ActeurDTO> acteurs;
    private List<String> categories;

    public FilmDetailledDTO() {
    }

    public FilmDetailledDTO(String title, String imgURL, List<ActeurDTO> acteurs, List<String> categories) {
        this.title = title;
        this.imgURL = imgURL;
        this.acteurs = acteurs;
        this.categories = categories;
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

    public List<ActeurDTO> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<ActeurDTO> acteurs) {
        this.acteurs = acteurs;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
