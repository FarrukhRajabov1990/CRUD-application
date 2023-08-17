package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxpayerTypeSelfEmployed;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaxpayerTypeSelfEmployed {

    private final EntityManager entityManager;

    public List<ClassifierTaxpayerTypeSelfEmployed> findAllBySimpleQuery(
            String name, String updatedBy, Long version ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierTaxpayerTypeSelfEmployed> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierTaxpayerTypeSelfEmployed.class);

        Root<ClassifierTaxpayerTypeSelfEmployed> root = criteriaQuery.from(ClassifierTaxpayerTypeSelfEmployed.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, updatedByPredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierTaxpayerTypeSelfEmployed> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
