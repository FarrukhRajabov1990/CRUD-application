package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierRelationDegree;

import java.util.Optional;

@Repository
public interface ClassifierRelationDegreeRepo extends JpaRepository<ClassifierRelationDegree, String> {
    Optional<ClassifierRelationDegree> findById(String id);
}
