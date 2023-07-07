package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierDehkanFarmActivityType;

import java.util.Optional;

@Repository
public interface ClassifierDehkanFarmActivityTypeRepo extends

        JpaRepository<ClassifierDehkanFarmActivityType, String> {
    Optional<ClassifierDehkanFarmActivityType> findById(String id);
}
