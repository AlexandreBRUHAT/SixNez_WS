package fr.polytech.sixnez.dtos;

public class FilmsDTO {

    private String name;
    private String imgURL;

    public FilmsDTO(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
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
}
