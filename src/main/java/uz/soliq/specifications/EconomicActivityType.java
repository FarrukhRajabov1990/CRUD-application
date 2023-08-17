package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierEconomicActivityType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EconomicActivityType {

    private final EntityManager entityManager;

    public List<ClassifierEconomicActivityType> findAllBySimpleQuery(
            String createdBy,  String deletedBy, String updatedBy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierEconomicActivityType> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierEconomicActivityType.class);

        Root<ClassifierEconomicActivityType> root = criteriaQuery.from(ClassifierEconomicActivityType.class);

        Predicate createdByPredicate = criteriaBuilder.like(root.get("createdBy"), "%" + createdBy + "%");
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, updatedByPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierEconomicActivityType> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
