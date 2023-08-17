package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierSector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Sector {

    private final EntityManager entityManager;

    public List<ClassifierSector> findAllBySimpleQuery(
            String name, String nameUzLatn, Long version) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierSector> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierSector.class);

        Root<ClassifierSector> root = criteriaQuery.from(ClassifierSector.class);

        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), name);
        Predicate nameUzLatnPredicate = criteriaBuilder.like(root.get("nameUzLatn"), "%" + nameUzLatn + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(namePredicate, nameUzLatnPredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierSector> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
