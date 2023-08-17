package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierEconomicActivityType;

import java.util.Optional;

@Repository
public interface ClassifierEconomicActivityTypeRepo extends JpaRepository<ClassifierEconomicActivityType,
        String> {Optional<ClassifierEconomicActivityType> findById(String id);
}
