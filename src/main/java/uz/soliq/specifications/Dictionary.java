package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierDictionary;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Dictionary {

    private final EntityManager entityManager;

    public List<ClassifierDictionary> findAllBySimpleQuery(
            String name, String nameUzLatn, String updatedBy ) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierDictionary> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierDictionary.class);

        Root<ClassifierDictionary> root = criteriaQuery.from(ClassifierDictionary.class);

        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), name);
        Predicate nameUzLatnPredicate = criteriaBuilder.like(root.get("nameUzLatn"), "%" + nameUzLatn + "%");
        Predicate updatedByPredicate = criteriaBuilder.equal(root.get("updatedBy"), updatedBy);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, nameUzLatnPredicate, updatedByPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierDictionary> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
