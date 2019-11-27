package fr.polytech.sixnez.specifications;

import fr.polytech.sixnez.dtos.FilterActeurDTO;
import fr.polytech.sixnez.dtos.FilterFilmDTO;
import fr.polytech.sixnez.entities.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActeurSpecification {

    public Specification<ActeurEntity> getActeursByFilters(FilterActeurDTO filter) {
        return new Specification<ActeurEntity>() {
            @Override
            public Predicate toPredicate(Root<ActeurEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(filter == null) {
                    return null;
                }

                if(filter.getLikeNom() != null && !filter.getLikeNom().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get(ActeurEntity_.nomPrenom), "%" + filter.getLikeNom() + "%"));
                }

                if(filter.getMetier() != null && !filter.getMetier().isEmpty()) {
                    Join<ActeurEntity, ProfessionEntity> professions = root.join(ProfessionEntity_.ACTEUR_BY_ID_ACTEUR);
                    predicates.add(criteriaBuilder.equal(professions.get(ProfessionEntity_.METIER), filter.getMetier()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
