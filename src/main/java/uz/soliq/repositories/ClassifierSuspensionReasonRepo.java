package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierSuspensionReason;

import java.util.Optional;

@Repository
public interface ClassifierSuspensionReasonRepo extends JpaRepository<ClassifierSuspensionReason, String> {
    Optional<ClassifierSuspensionReason> findById(String id);
}
