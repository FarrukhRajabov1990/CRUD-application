package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBankPurpose;

import java.util.Optional;

@Repository
public interface ClassifierBankPurposeRepo extends JpaRepository<ClassifierBankPurpose, String> {
    Optional<ClassifierBankPurpose> findById(String id);
}
