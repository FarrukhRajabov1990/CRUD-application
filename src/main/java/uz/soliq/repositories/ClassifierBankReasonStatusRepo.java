package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBankReasonStatus;

import java.util.Optional;

@Repository
public interface ClassifierBankReasonStatusRepo extends JpaRepository<ClassifierBankReasonStatus, String> {
    Optional<ClassifierBankReasonStatus> findById(String id);
}
