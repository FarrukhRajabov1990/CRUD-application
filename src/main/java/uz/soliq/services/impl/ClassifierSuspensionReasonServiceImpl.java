package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSuspensionReasonDTO;
import uz.soliq.entities.ClassifierSuspensionReason;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierSuspensionReasonMapper;
import uz.soliq.repositories.ClassifierSuspensionReasonRepo;
import uz.soliq.services.ClassifierSuspensionReasonService;
import uz.soliq.specifications.SuspensionReasonSearch;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierSuspensionReasonServiceImpl implements ClassifierSuspensionReasonService {

    private final ClassifierSuspensionReasonRepo repo;
    private final ClassifierSuspensionReasonMapper mapper;
    private final SuspensionReasonSearch querySearch;

    @Override
    public ClassifierSuspensionReason findById(String id) throws CustomNotFoundException {
        Optional<ClassifierSuspensionReason> reasonOptional = repo.findById(id);
        if (reasonOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return reasonOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSuspensionReason>> add(ClassifierSuspensionReasonDTO dto) {
        ClassifierSuspensionReason classifierSuspensionReason = mapper.toEntity(dto);
        repo.save(classifierSuspensionReason);
        return ResponseData.success201(classifierSuspensionReason);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSuspensionReason>> edit(ClassifierSuspensionReasonDTO dto) {
        Optional<ClassifierSuspensionReason> reasonOptional = repo.findById(dto.getId());
        if (reasonOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierSuspensionReason classifierSuspensionReason = mapper.toEntity(dto);
        repo.save(classifierSuspensionReason);
        return ResponseData.success201(classifierSuspensionReason);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierSuspensionReason> reasonOptional = repo.findById(id);
        if (reasonOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(reasonOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> findBySimpleQuery(
            Integer code, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, version));
    }


}
