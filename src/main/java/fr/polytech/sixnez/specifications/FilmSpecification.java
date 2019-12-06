package fr.polytech.sixnez.specifications;

import fr.polytech.sixnez.entities.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmSpecification {

    public Specification<FilmEntity> getFilmsByFilters(String genre, String like, int annee) {
        return new Specification<FilmEntity>() {
            @Override
            public Predicate toPredicate(Root<FilmEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(like != null && !like.isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get(FilmEntity_.titre), "%" + like + "%"));
                }

                if(annee != 0) {
                    predicates.add(criteriaBuilder.equal(root.get(FilmEntity_.annee), annee));
                }

                if(genre != null && genre != null) {
                    Join<FilmEntity, CategorieEntity> genres = root.join(FilmEntity_.CATEGORIES_BY_ID_FILM);
                    predicates.add(genres.get(GenreEntity_.GENRE).in(genre));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    public Specification<FilmEntity> getFilmsByFavs(String username) {
        return new Specification<FilmEntity>() {
            @Override
            public Predicate toPredicate(Root<FilmEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<FilmEntity, FavsEntity> favsEntityJoin = root.join(FilmEntity_.FAVS_BY_ID_FILM);

                return criteriaBuilder.equal(favsEntityJoin.get(FavsEntity_.USERNAME), username);
            }
        };
    }
}
