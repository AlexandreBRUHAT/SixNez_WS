package fr.polytech.sixnez.specifications;

import fr.polytech.sixnez.dtos.FilterFilmDTO;
import fr.polytech.sixnez.entities.CategorieEntity;
import fr.polytech.sixnez.entities.FilmEntity;
import fr.polytech.sixnez.entities.FilmEntity_;
import fr.polytech.sixnez.entities.GenreEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmSpecification {

    public Specification<FilmEntity> getFilmsByFilters(FilterFilmDTO filter) {
        return new Specification<FilmEntity>() {
            @Override
            public Predicate toPredicate(Root<FilmEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(filter == null) {
                    return null;
                }

                if(filter.getLikeTitre() != null && !filter.getLikeTitre().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get(FilmEntity_.titre), "%" + filter.getLikeTitre() + "%"));
                }

                if(filter.getAnnee() != 0) {
                    predicates.add(criteriaBuilder.equal(root.get(FilmEntity_.annee), filter.getAnnee()));
                }

                if(filter.getGenres() != null && filter.getGenres() != null) {
                    Join<FilmEntity, CategorieEntity> genres = root.join(FilmEntity_.CATEGORIES_BY_ID_FILM);
                    predicates.add(genres.get(GenreEntity_.GENRE).in(filter.getGenres()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
