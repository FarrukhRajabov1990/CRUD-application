package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierLegalForms;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LegalForms {

    private final EntityManager entityManager;

    public List<ClassifierLegalForms> findAllBySimpleQuery(
            String createdBy, String deletedBy, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierLegalForms> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierLegalForms.class);

        Root<ClassifierLegalForms> root = criteriaQuery.from(ClassifierLegalForms.class);

        Predicate createdByPredicate = criteriaBuilder.equal(root.get("createdBy"), createdBy);
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), name);

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, namePredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierLegalForms> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
