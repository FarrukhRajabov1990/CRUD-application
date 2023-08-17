package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierOkruz;

import java.util.Optional;

@Repository
public interface ClassifierOkruzRepo extends JpaRepository<ClassifierOkruz, String> {
    Optional<ClassifierOkruz> findById(String id);
}
