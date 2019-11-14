package fr.polytech.sixnez.dtos;

public class FilmDTO {


    private String name;
    private String imgURL;
    private String id;

    public FilmDTO(String name, String imgURL, String id) {
        this.name = name;
        this.imgURL = imgURL;
        this.id = id;
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
}
