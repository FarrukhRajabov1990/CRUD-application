package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierBank;

import java.util.Optional;

@Repository
public interface ClassifierBankRepo extends JpaRepository<ClassifierBank, String> {
    Optional<ClassifierBank> findById(String id);
}
