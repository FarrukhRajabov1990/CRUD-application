package uz.soliq.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierMahallaOldStructure;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MahallaOldStructure {

    private final EntityManager entityManager;

    public List<ClassifierMahallaOldStructure> findAllBySimpleQuery(
            String name, Integer code, Long version) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClassifierMahallaOldStructure> criteriaQuery = criteriaBuilder
                .createQuery(ClassifierMahallaOldStructure.class);

        Root<ClassifierMahallaOldStructure> root = criteriaQuery.from(ClassifierMahallaOldStructure.class);

        Predicate codePredicate = criteriaBuilder.equal(root.get("code"), code);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate versionPredicate = criteriaBuilder.equal(root.get("version"), version);

        Predicate orPredicate = criteriaBuilder.or(codePredicate, namePredicate, versionPredicate);

        criteriaQuery.where(orPredicate);
        TypedQuery<ClassifierMahallaOldStructure> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
