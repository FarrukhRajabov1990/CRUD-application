package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxpayerType;

import java.util.Optional;

@Repository
public interface ClassifierTaxPayerTypeRepo extends JpaRepository<ClassifierTaxpayerType, String> {
    Optional<ClassifierTaxpayerType> findById(String id);
}
