package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTerritorialUnit;

import java.util.Optional;

@Repository
public interface ClassifierTerritorialUnitRepo extends JpaRepository<ClassifierTerritorialUnit, String> {
    Optional<ClassifierTerritorialUnit> findById(String id);
}
