package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierProduct;

import java.util.Optional;

@Repository
public interface ClassifierProductRepo extends JpaRepository<ClassifierProduct, String> {
    Optional<ClassifierProduct> findById(String id);
}
