package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierGender;

import java.util.Optional;

@Repository
public interface ClassifierGenderRepo extends JpaRepository<ClassifierGender, String> {
    Optional<ClassifierGender> findById(String id);
}
