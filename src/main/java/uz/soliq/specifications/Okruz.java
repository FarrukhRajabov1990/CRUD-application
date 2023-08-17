package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierOkruz;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Okruz {

    private final EntityManager entityManager;

    public List<ClassifierOkruz> findAllBySimpleQuery(
            String createdBy, String deletedBy, String okruzCode) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierOkruz> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierOkruz.class);

        Root<ClassifierOkruz> root = criteriaQuery.from(ClassifierOkruz.class);

        Predicate createdByPredicate = criteriaBuilder.equal(root.get("createdBy"), createdBy);
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate okruzCodePredicate = criteriaBuilder.like(root.get("okruzCode"), "%" + okruzCode + "%");

        Predicate orPredicate = criteriaBuilder.or(createdByPredicate, deletedByPredicate, okruzCodePredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierOkruz> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
