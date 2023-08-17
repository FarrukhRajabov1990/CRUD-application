package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierLegalFormsDTO;
import uz.soliq.entities.ClassifierLegalForms;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierLegalFormsMapper;
import uz.soliq.repositories.ClassifierLegalFormsRepo;
import uz.soliq.services.ClassifierLegalFormsService;
import uz.soliq.specifications.LegalForms;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierLegalFormsServiceImpl implements ClassifierLegalFormsService {

    private final ClassifierLegalFormsRepo repo;
    private final ClassifierLegalFormsMapper mapper;
    private final LegalForms querySearch;

    @Override
    public ClassifierLegalForms findById(String id) throws CustomNotFoundException {
        Optional<ClassifierLegalForms> forms = repo.findById(id);
        if (forms.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return forms.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierLegalForms>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierLegalForms>> add(ClassifierLegalFormsDTO dto) {
        ClassifierLegalForms forms = mapper.toEntity(dto);
        repo.save(forms);
        return ResponseData.success201(forms);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierLegalForms>> edit(ClassifierLegalFormsDTO dto) {
        Optional<ClassifierLegalForms> formsOptional = repo.findById(dto.getId());
        if (formsOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierLegalForms legalForms = mapper.toEntity(dto);
        repo.save(legalForms);
        return ResponseData.success201(legalForms);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierLegalForms> forms = repo.findById(id);
        if (forms.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(forms.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierLegalForms>>> findBySimpleQuery(
            String createdBy, String deletedBy, String name) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, deletedBy, name));
    }
}
