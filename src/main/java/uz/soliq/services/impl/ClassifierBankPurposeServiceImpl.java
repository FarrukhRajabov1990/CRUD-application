package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankPurposeDTO;
import uz.soliq.entities.ClassifierBankPurpose;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierBankPurposeMapper;
import uz.soliq.repositories.ClassifierBankPurposeRepo;
import uz.soliq.services.ClassifierBankPurposeService;
import uz.soliq.specifications.BankPurpose;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierBankPurposeServiceImpl implements ClassifierBankPurposeService {

    private final ClassifierBankPurposeRepo repo;
    private final ClassifierBankPurposeMapper mapper;
    private final BankPurpose querySearch;

    @Override
    public ClassifierBankPurpose findById(String id) throws CustomNotFoundException {
        Optional<ClassifierBankPurpose> bankPurposeOptional = repo.findById(id);
        if (bankPurposeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return bankPurposeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBankPurpose>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBankPurpose>> add(ClassifierBankPurposeDTO dto) {
        ClassifierBankPurpose bankPurpose = mapper.toEntity(dto);
        repo.save(bankPurpose);
        return ResponseData.success201(bankPurpose);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBankPurpose>> edit(ClassifierBankPurposeDTO dto) {
        Optional<ClassifierBankPurpose> bankPurposeOptional = repo.findById(dto.getId());
        if (bankPurposeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierBankPurpose bankPurpose = mapper.toEntity(dto);
        repo.save(bankPurpose);
        return ResponseData.success201(bankPurpose);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierBankPurpose> bankPurposeOptional = repo.findById(id);
        if (bankPurposeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(bankPurposeOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBankPurpose>>> findBySimpleQuery(
            String name, String updatedBy, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(name, updatedBy, version));
    }
}
