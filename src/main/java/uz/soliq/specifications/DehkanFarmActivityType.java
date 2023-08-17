package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierDehkanFarmActivityType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DehkanFarmActivityType {

    private final EntityManager entityManager;

    public List<ClassifierDehkanFarmActivityType> findAllBySimpleQuery(
            String code, String name, String updatedBy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierDehkanFarmActivityType> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierDehkanFarmActivityType.class);

        Root<ClassifierDehkanFarmActivityType> root = criteriaQuery.from(ClassifierDehkanFarmActivityType.class);

        Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + code + "%");
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");

        Predicate orPredicate = criteriaBuilder.or(codePredicate, namePredicate, updatedByPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierDehkanFarmActivityType> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
