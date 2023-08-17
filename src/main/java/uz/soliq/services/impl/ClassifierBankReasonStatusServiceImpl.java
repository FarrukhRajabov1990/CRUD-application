package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankReasonStatusDTO;
import uz.soliq.entities.ClassifierBankReasonStatus;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierBankReasonStatusMapper;
import uz.soliq.repositories.ClassifierBankReasonStatusRepo;
import uz.soliq.services.ClassifierBankReasonStatusService;
import uz.soliq.specifications.BankReasonStatus;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierBankReasonStatusServiceImpl implements ClassifierBankReasonStatusService {

    private final ClassifierBankReasonStatusRepo repo;
    private final ClassifierBankReasonStatusMapper mapper;
    private final BankReasonStatus querySearch;

    @Override
    public ClassifierBankReasonStatus findById(String id) throws CustomNotFoundException {
        Optional<ClassifierBankReasonStatus> status = repo.findById(id);
        if (status.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return status.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBankReasonStatus>> add(ClassifierBankReasonStatusDTO dto) {
        ClassifierBankReasonStatus status = mapper.toEntity(dto);
        repo.save(status);
        return ResponseData.success201(status);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBankReasonStatus>> edit(ClassifierBankReasonStatusDTO dto) {
        Optional<ClassifierBankReasonStatus> statusOptional = repo.findById(dto.getId());
        if (statusOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierBankReasonStatus status = mapper.toEntity(dto);
        repo.save(status);
        return ResponseData.success201(status);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierBankReasonStatus> status = repo.findById(id);
        if (status.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(status.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> findBySimpleQuery(
            String createdBy, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, name, version));
    }
}
