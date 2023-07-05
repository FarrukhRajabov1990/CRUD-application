package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBusinessType;

import java.util.Optional;

@Repository
public interface ClassifierBusinessTypeRepo extends JpaRepository<ClassifierBusinessType, String> {
    Optional<ClassifierBusinessType> findById(String id);
}
