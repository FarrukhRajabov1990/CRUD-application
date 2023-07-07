package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierTaxpayerTypeSelfEmployed;

import java.util.Optional;

@Repository
public interface ClassifierTaxpayerTypeSelfEmployedRepo extends

        JpaRepository<ClassifierTaxpayerTypeSelfEmployed, String> {
    Optional<ClassifierTaxpayerTypeSelfEmployed> findById(String id);
}
