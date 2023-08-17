package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierCraftsmanActivityType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CraftsmanActivityType {

    private final EntityManager entityManager;

    public List<ClassifierCraftsmanActivityType> findAllBySimpleQuery(
            String code, String name, String updatedBy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierCraftsmanActivityType> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierCraftsmanActivityType.class);

        Root<ClassifierCraftsmanActivityType> root = criteriaQuery.from(ClassifierCraftsmanActivityType.class);

        Predicate codePredicate = criteriaBuilder.equal(root.get("code"), code);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate updatedByPredicate = criteriaBuilder.equal(root.get("updatedBy"), updatedBy);

        Predicate orPredicate = criteriaBuilder.or(codePredicate, namePredicate, updatedByPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierCraftsmanActivityType> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
