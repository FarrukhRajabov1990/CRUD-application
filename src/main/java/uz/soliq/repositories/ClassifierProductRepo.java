package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;

import java.util.Optional;

@Repository
public interface ClassifierArgosTerritorialLevelRepo extends JpaRepository<
        ClassifierArgosTerritorialLevel, String> {
    Optional<ClassifierArgosTerritorialLevel> findById(String id);
}
