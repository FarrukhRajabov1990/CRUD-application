package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxInspections;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaxInspections {

    private final EntityManager entityManager;

    public List<ClassifierTaxInspections> findAllBySimpleQuery(
            String name, String adres, String account ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierTaxInspections> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierTaxInspections.class);

        Root<ClassifierTaxInspections> root = criteriaQuery.from(ClassifierTaxInspections.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate adresPredicate = criteriaBuilder.like(root.get("adres"), "%" + adres + "%");
        Predicate accountPredicate = criteriaBuilder.like(root.get("account"), account);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, adresPredicate, accountPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierTaxInspections> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
