package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBankReasonStatus;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BankReasonStatus {

    private final EntityManager entityManager;

    public List<ClassifierBankReasonStatus> findAllBySimpleQuery(
            String createdBy, String name, Long version ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierBankReasonStatus> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierBankReasonStatus.class);

        Root<ClassifierBankReasonStatus> root = criteriaQuery.from(ClassifierBankReasonStatus.class);

        Predicate createdByPredicate = criteriaBuilder.equal(root.get("createdBy"), createdBy);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, namePredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierBankReasonStatus> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
