package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxpayerType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaxpayerType {

    private final EntityManager entityManager;

    public List<ClassifierTaxpayerType> findAllBySimpleQuery(
            String code, String name, Long version ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierTaxpayerType> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierTaxpayerType.class);

        Root<ClassifierTaxpayerType> root = criteriaQuery.from(ClassifierTaxpayerType.class);

        Predicate codePredicate = criteriaBuilder.equal(root.get("code"), code);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(codePredicate, namePredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierTaxpayerType> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
