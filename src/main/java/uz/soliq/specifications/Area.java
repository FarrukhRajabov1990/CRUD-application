package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierArea;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Area {

    private final EntityManager entityManager;

    public List<ClassifierArea> findAllBySimpleQuery(
            Long version, String areaId, String regionId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierArea> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierArea.class);

        Root<ClassifierArea> root = criteriaQuery.from(ClassifierArea.class);

        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + areaId + "%");
        Predicate regionIdPredicate = criteriaBuilder.like(root.get("name"), "%" + regionId + "%");

        Predicate orPredicate = criteriaBuilder.or(versionPredicate, namePredicate, regionIdPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierArea> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
