package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxInspectionsDTO;
import uz.soliq.entities.ClassifierTaxInspections;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierTaxInspectionsMapper;
import uz.soliq.repositories.ClassifierTaxInspectionsRepo;
import uz.soliq.services.ClassifierTaxInspectionsService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierTaxInspectionsServiceImpl implements ClassifierTaxInspectionsService {

    private final ClassifierTaxInspectionsRepo repo;
    private final ClassifierTaxInspectionsMapper mapper;

    @Override
    public ClassifierTaxInspections findById(String id) throws CustomNotFoundException {
        Optional<ClassifierTaxInspections> taxInspectionsOptional = repo.findById(id);
        if (taxInspectionsOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return taxInspectionsOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTaxInspections>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxInspections>> add(ClassifierTaxInspectionsDTO dto) {
        ClassifierTaxInspections classifierTaxInspections = mapper.toEntity(dto);
        repo.save(classifierTaxInspections);
        return ResponseData.success201(classifierTaxInspections);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxInspections>> edit(ClassifierTaxInspectionsDTO dto) {
        Optional<ClassifierTaxInspections> taxInspectionsOptional = repo.findById(dto.getId());
        if (taxInspectionsOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierTaxInspections classifierTaxInspections = mapper.toEntity(dto);
        repo.save(classifierTaxInspections);
        return ResponseData.success201(classifierTaxInspections);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierTaxInspections> taxInspectionsOptional = repo.findById(id);
        if (taxInspectionsOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(taxInspectionsOptional.get());
        return ResponseData.success200(true);
    }
}
