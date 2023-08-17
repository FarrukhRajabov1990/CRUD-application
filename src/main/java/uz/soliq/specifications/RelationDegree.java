package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierRelationDegree;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RelationDegree {

    private final EntityManager entityManager;

    public List<ClassifierRelationDegree> findAllBySimpleQuery(
            String code,  String deletedBy, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierRelationDegree> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierRelationDegree.class);

        Root<ClassifierRelationDegree> root = criteriaQuery.from(ClassifierRelationDegree.class);

        Predicate codePredicate = criteriaBuilder.like(root.get("code"), "%" + code + "%");
        Predicate deletedByPredicate = criteriaBuilder.like(root.get("deletedBy"), "%" + deletedBy + "%");
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");

        Predicate orPredicate = criteriaBuilder.or(codePredicate, deletedByPredicate, namePredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierRelationDegree> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
