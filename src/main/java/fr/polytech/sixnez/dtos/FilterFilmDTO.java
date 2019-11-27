package fr.polytech.sixnez.dtos;

import java.util.List;

public class FilterFilmDTO implements FilterDTO {

    private String likeTitre;
    private int annee;
    private List<String> genres;

    public FilterFilmDTO() {
    }

    public FilterFilmDTO(String likeTitre, int annee, List<String> genres) {
        this.likeTitre = likeTitre;
        this.annee = annee;
        this.genres = genres;
    }

    public String getLikeTitre() {
        return likeTitre;
    }

    public void setLikeTitre(String likeTitre) {
        this.likeTitre = likeTitre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int date) {
        this.annee = date;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
