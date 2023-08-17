package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierMahalla;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Mahalla {

    private final EntityManager entityManager;

    public List<ClassifierMahalla> findAllBySimpleQuery(
            String name, Long code, Long version) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierMahalla> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierMahalla.class);

        Root<ClassifierMahalla> root = criteriaQuery.from(ClassifierMahalla.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate codePredicate = criteriaBuilder.equal(root.get("code"), code);
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, codePredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierMahalla> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
