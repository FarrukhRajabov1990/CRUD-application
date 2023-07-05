package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierArgosCategory;

import java.util.Optional;

@Repository
public interface ClassifierArgosCategoryRepo extends JpaRepository<ClassifierArgosCategory, String> {
    Optional<ClassifierArgosCategory> findById(String id);
}
