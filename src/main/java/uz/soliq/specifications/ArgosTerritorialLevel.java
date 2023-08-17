package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArgosTerritorialLevel {

    private final EntityManager entityManager;

    public List<ClassifierArgosTerritorialLevel> findAllBySimpleQuery(
            String createdBy,  String deletedBy, String updatedBy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierArgosTerritorialLevel> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierArgosTerritorialLevel.class);

        Root<ClassifierArgosTerritorialLevel> root = criteriaQuery.from(ClassifierArgosTerritorialLevel.class);

        Predicate createdByPredicate = criteriaBuilder.like(root.get("createdBy"), "%" + createdBy + "%");
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, updatedByPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierArgosTerritorialLevel> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
