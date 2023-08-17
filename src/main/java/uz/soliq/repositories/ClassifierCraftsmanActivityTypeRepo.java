package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierCraftsmanActivityType;

import java.util.Optional;

@Repository
public interface ClassifierCraftsmanActivityTypeRepo extends JpaRepository<ClassifierCraftsmanActivityType, String> {
    Optional<ClassifierCraftsmanActivityType> findById(String id);
}
