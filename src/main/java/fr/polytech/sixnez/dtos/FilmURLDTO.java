package fr.polytech.sixnez.dtos;

public class FilmURLDTO {

    private String imgURL;
    private String id;

    public FilmURLDTO(String imgURL, String id) {
        this.imgURL = imgURL;
        this.id = id;
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
}
