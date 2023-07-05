package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierMahallaOldStructure;

import java.util.Optional;

@Repository
public interface ClassifierMahallaOldStructureRepo extends JpaRepository<ClassifierMahallaOldStructure, String> {
    Optional<ClassifierMahallaOldStructure> findById(String id);
}
