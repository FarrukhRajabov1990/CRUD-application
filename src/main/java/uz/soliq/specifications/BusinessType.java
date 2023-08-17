package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBusinessType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BusinessType {

    private final EntityManager entityManager;

    public List<ClassifierBusinessType> findAllBySimpleQuery(
            String name, String updatedBy, Long version ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierBusinessType> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierBusinessType.class);

        Root<ClassifierBusinessType> root = criteriaQuery.from(ClassifierBusinessType.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, updatedByPredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierBusinessType> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
