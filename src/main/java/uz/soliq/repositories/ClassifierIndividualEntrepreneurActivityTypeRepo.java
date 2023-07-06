package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierIndividualEntrepreneurActivityType;

import java.util.Optional;

@Repository
public interface ClassifierIndividualEntrepreneurActivityTypeRepo extends
        JpaRepository<ClassifierIndividualEntrepreneurActivityType, String> {
    Optional<ClassifierIndividualEntrepreneurActivityType> findById(String id);
}
