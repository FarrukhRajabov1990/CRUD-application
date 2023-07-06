package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankDTO;
import uz.soliq.entities.ClassifierBank;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierBankMapper;
import uz.soliq.repositories.ClassifierBankRepo;
import uz.soliq.services.ClassifierBankService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierBankServiceImpl implements ClassifierBankService {

    private final ClassifierBankRepo repo;
    private final ClassifierBankMapper mapper;

    @Override
    public ClassifierBank findById(String id) throws CustomNotFoundException {
        Optional<ClassifierBank> bankOptional = repo.findById(id);
        if (bankOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return bankOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBank>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBank>> add(ClassifierBankDTO dto) {
        ClassifierBank bank = mapper.toEntity(dto);
        repo.save(bank);
        return ResponseData.success201(bank);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBank>> edit(ClassifierBankDTO dto) {
        Optional<ClassifierBank> bankOptional = repo.findById(dto.getId());
        if (bankOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierBank bank = mapper.toEntity(dto);
        repo.save(bank);
        return ResponseData.success201(bank);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierBank> bankOptional = repo.findById(id);
        if (bankOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(bankOptional.get());
        return ResponseData.success200(true);
    }
}
