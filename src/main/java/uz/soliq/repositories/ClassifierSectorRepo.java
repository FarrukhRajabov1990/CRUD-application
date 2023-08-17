package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierSector;

import java.util.Optional;

@Repository
public interface ClassifierSectorRepo extends JpaRepository<ClassifierSector, String> {
    Optional<ClassifierSector> findById(String id);
}
