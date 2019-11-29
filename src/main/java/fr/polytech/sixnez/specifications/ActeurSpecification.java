package fr.polytech.sixnez.specifications;

import fr.polytech.sixnez.entities.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActeurSpecification {

    public Specification<ActeurEntity> getActeursByFilters(String like, String metier) {
        return new Specification<ActeurEntity>() {
            @Override
            public Predicate toPredicate(Root<ActeurEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(like != null && !like.isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get(ActeurEntity_.nomPrenom), "%" + like + "%"));
                }

                if(metier != null && !metier.isEmpty()) {
                    Join<ActeurEntity, ProfessionEntity> professions = root.join(ActeurEntity_.PROFESSIONS_BY_ID_ACTEUR);
                    predicates.add(criteriaBuilder.equal(professions.get(ProfessionEntity_.METIER), metier));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
