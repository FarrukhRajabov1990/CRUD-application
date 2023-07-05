package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeDTO;
import uz.soliq.entities.ClassifierTaxpayerType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierTaxpayerTypeMapper;
import uz.soliq.repositories.ClassifierTaxPayerTypeRepo;
import uz.soliq.services.ClassifierTaxpayerTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierTaxpayerTypeServiceImpl implements ClassifierTaxpayerTypeService {

    private final ClassifierTaxPayerTypeRepo repo;
    private final ClassifierTaxpayerTypeMapper mapper;

    @Override
    public ClassifierTaxpayerType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierTaxpayerType> taxpayerTypeOptional = repo.findById(id);
        if (taxpayerTypeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return taxpayerTypeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxpayerType>> add(ClassifierTaxpayerTypeDTO dto) {
        ClassifierTaxpayerType taxpayerType = mapper.toEntity(dto);
        repo.save(taxpayerType);
        return ResponseData.success201(taxpayerType);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxpayerType>> edit(ClassifierTaxpayerTypeDTO dto) {
        Optional<ClassifierTaxpayerType> taxpayerTypeOptional = repo.findById(dto.getId());
        if (taxpayerTypeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierTaxpayerType taxpayerType = mapper.toEntity(dto);
        repo.save(taxpayerType);
        return ResponseData.success201(taxpayerType);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierTaxpayerType> taxpayerTypeOptional = repo.findById(id);
        if (taxpayerTypeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(taxpayerTypeOptional.get());
        return ResponseData.success200(true);
    }
}
