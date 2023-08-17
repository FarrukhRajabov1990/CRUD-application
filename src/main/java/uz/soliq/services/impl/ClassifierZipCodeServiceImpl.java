package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierZipCodeDTO;
import uz.soliq.entities.ClassifierZipCode;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierZipCodeMapper;
import uz.soliq.repositories.ClassifierZipCodeRepo;
import uz.soliq.services.ClassifierZipCodeService;
import uz.soliq.specifications.ZipCode;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierZipCodeServiceImpl implements ClassifierZipCodeService {

    private final ClassifierZipCodeRepo repo;
    private final ClassifierZipCodeMapper mapper;
    private final ZipCode querySearch;

    @Override
    public ClassifierZipCode findById(String id) throws CustomNotFoundException {
        Optional<ClassifierZipCode> zipCodeOptional = repo.findById(id);
        if (zipCodeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return zipCodeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierZipCode>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierZipCode>> add(ClassifierZipCodeDTO dto) {
        ClassifierZipCode zipCode = mapper.toEntity(dto);
        repo.save(zipCode);
        return ResponseData.success201(zipCode);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierZipCode>> edit(ClassifierZipCodeDTO dto) {
        Optional<ClassifierZipCode> zipCodeOptional = repo.findById(dto.getId());
        if (zipCodeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierZipCode zipCode = mapper.toEntity(dto);
        repo.save(zipCode);
        return ResponseData.success201(zipCode);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierZipCode> zipCodeOptional = repo.findById(id);
        if (zipCodeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(zipCodeOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierZipCode>>> findBySimpleQuery(
            String createdBy,  String deletedBy, String updatedBy) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, deletedBy, updatedBy));
    }
}
