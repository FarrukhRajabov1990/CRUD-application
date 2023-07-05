package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierMahalla;

import java.util.Optional;

@Repository
public interface ClassifierMahallaRepo extends JpaRepository<ClassifierMahalla, String> {
    Optional<ClassifierMahalla> findById(String id);
}
