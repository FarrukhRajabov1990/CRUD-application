package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierSoato;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Soato {

    private final EntityManager entityManager;

    public List<ClassifierSoato> findAllBySimpleQuery(
            String createdBy, String deletedBy, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierSoato> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierSoato.class);

        Root<ClassifierSoato> root = criteriaQuery.from(ClassifierSoato.class);

        Predicate createdByPredicate = criteriaBuilder.like(root.get("createdBy"), "%" + createdBy + "%");
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, namePredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierSoato> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
