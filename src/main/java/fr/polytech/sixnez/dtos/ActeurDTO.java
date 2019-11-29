package fr.polytech.sixnez.dtos;

import java.util.List;

public class ActeurDTO {
    private String id;
    private String nomPrenom;

    public ActeurDTO(String id, String nomPrenom) {
        this.id = id;
        this.nomPrenom = nomPrenom;
    }

    public ActeurDTO() {
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
}
