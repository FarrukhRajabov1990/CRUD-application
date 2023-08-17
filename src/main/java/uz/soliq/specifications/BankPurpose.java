package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBankPurpose;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BankPurpose {

    private final EntityManager entityManager;

    public List<ClassifierBankPurpose> findAllBySimpleQuery(
            String name, String updatedBy, Long version ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierBankPurpose> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierBankPurpose.class);

        Root<ClassifierBankPurpose> root = criteriaQuery.from(ClassifierBankPurpose.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate updatedByPredicate = criteriaBuilder.like(root.get("updatedBy"), "%" + updatedBy + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, updatedByPredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierBankPurpose> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
