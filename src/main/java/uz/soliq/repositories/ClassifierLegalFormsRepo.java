package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierLegalForms;

import java.util.Optional;

@Repository
public interface ClassifierLegalFormsRepo extends JpaRepository<ClassifierLegalForms, String> {
    Optional<ClassifierLegalForms> findById(String id);
}
