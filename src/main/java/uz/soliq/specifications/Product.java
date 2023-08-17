package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierProduct;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Product {

    private final EntityManager entityManager;

    public List<ClassifierProduct> findAllBySimpleQuery(
            String createdBy,  String deletedBy, String section) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierProduct> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierProduct.class);

        Root<ClassifierProduct> root = criteriaQuery.from(ClassifierProduct.class);

        Predicate createdByPredicate = criteriaBuilder.like(root.get("createdBy"), "%" + createdBy + "%");
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate sectionPredicate = criteriaBuilder.like(root.get("section"), "%" + section + "%");

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, sectionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierProduct> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
