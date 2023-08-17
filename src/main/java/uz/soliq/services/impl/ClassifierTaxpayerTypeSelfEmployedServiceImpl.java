package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeSelfEmployedDTO;
import uz.soliq.entities.ClassifierTaxpayerTypeSelfEmployed;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierTaxpayerTypeSelfEmployedMapper;
import uz.soliq.repositories.ClassifierTaxpayerTypeSelfEmployedRepo;
import uz.soliq.services.ClassifierTaxpayerTypeSelfEmployedService;
import uz.soliq.specifications.TaxpayerTypeSelfEmployed;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierTaxpayerTypeSelfEmployedServiceImpl implements
        ClassifierTaxpayerTypeSelfEmployedService {

    private final ClassifierTaxpayerTypeSelfEmployedRepo repo;
    private final ClassifierTaxpayerTypeSelfEmployedMapper mapper;
    private final TaxpayerTypeSelfEmployed querySearch;


    @Override
    public ClassifierTaxpayerTypeSelfEmployed findById(String id) throws CustomNotFoundException {
        Optional<ClassifierTaxpayerTypeSelfEmployed> employedOptional = repo.findById(id);
        if (employedOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return employedOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerTypeSelfEmployed>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> add
            (ClassifierTaxpayerTypeSelfEmployedDTO dto) {
        ClassifierTaxpayerTypeSelfEmployed employed = mapper.toEntity(dto);
        repo.save(employed);
        return ResponseData.success201(employed);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> edit
            (ClassifierTaxpayerTypeSelfEmployedDTO dto) {
        Optional<ClassifierTaxpayerTypeSelfEmployed> employedOptional = repo.findById(dto.getId());
        if (employedOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierTaxpayerTypeSelfEmployed employed = mapper.toEntity(dto);
        repo.save(employed);
        return ResponseData.success201(employed);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierTaxpayerTypeSelfEmployed> employedOptional = repo.findById(id);
        if (employedOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(employedOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerTypeSelfEmployed>>> findBySimpleQuery(
            String name, String updatedBy, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(name, updatedBy, version));
    }
}
