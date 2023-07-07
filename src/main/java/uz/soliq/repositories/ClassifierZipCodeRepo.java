package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierArea;

import java.util.Optional;

@Repository
public interface ClassifierAreaRepo extends JpaRepository<ClassifierArea, String> {
    Optional<ClassifierArea> findById(String id);
}
