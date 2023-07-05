package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxInspections;

import java.util.Optional;

@Repository
public interface ClassifierTaxInspectionsRepo extends JpaRepository<ClassifierTaxInspections, String> {
    Optional<ClassifierTaxInspections> findById(String id);
}
