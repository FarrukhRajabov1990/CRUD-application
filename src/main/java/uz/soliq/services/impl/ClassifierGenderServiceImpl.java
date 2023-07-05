package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierGenderDTO;
import uz.soliq.entities.ClassifierGender;
import uz.soliq.entities.ClassifierSuspensionReason;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierGenderMapper;
import uz.soliq.repositories.ClassifierGenderRepo;
import uz.soliq.services.ClassifierGenderService;
import uz.soliq.specifications.GenderSearch;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierGenderServiceImpl implements ClassifierGenderService {

    private final ClassifierGenderRepo repo;
    private final ClassifierGenderMapper mapper;
    private final GenderSearch querySearch;

    @Override
    public ClassifierGender findById(String id) throws CustomNotFoundException {
        Optional<ClassifierGender> reasonOptional = repo.findById(id);
        if (reasonOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return reasonOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierGender>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierGender>> add(ClassifierGenderDTO dto) {
        ClassifierGender classifierGender = mapper.toEntity(dto);
        repo.save(classifierGender);
        return ResponseData.success201(classifierGender);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierGender>> edit(ClassifierGenderDTO dto) {
        Optional<ClassifierGender> genderOptional = repo.findById(dto.getId());
        if (genderOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierGender classifierGender = mapper.toEntity(dto);
        repo.save(classifierGender);
        return ResponseData.success201(classifierGender);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierGender> genderOptional = repo.findById(id);
        if (genderOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(genderOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierGender>>> findBySimpleQuery(
            Integer code, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, version));
    }
}
