package fr.polytech.sixnez.dtos;

public class FilmDTO {

    private String name;
    private String imgURL;
    private String id;
    private Short annee;
    private Boolean fav;

    public FilmDTO(String name, String imgURL, String id, Boolean fav, Short annee) {
        this.name = name;
        this.imgURL = imgURL;
        this.id = id;
        this.fav = fav;
        this.annee = annee;
    }

    public Boolean getFav() {
        return fav;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }
}
