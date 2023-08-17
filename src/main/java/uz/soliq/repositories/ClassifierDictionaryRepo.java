package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierDictionary;

import java.util.Optional;

@Repository
public interface ClassifierDictionaryRepo extends JpaRepository<ClassifierDictionary, String> {
    Optional<ClassifierDictionary> findById(String id);
}
