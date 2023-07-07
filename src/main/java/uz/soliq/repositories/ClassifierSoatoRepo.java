package uz.soliq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.soliq.entities.ClassifierSoato;

import java.util.Optional;


@Repository
public interface ClassifierSoatoRepo extends JpaRepository<ClassifierSoato, String> {
    Optional<ClassifierSoato> findById(String id);
}
