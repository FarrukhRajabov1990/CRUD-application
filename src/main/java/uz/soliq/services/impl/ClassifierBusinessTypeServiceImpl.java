package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBusinessTypeDTO;
import uz.soliq.entities.ClassifierBusinessType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierBusinessTypeMapper;
import uz.soliq.repositories.ClassifierBusinessTypeRepo;
import uz.soliq.services.ClassifierBusinessTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierBusinessTypeServiceImpl implements ClassifierBusinessTypeService {

    private final ClassifierBusinessTypeRepo repo;
    private final ClassifierBusinessTypeMapper mapper;

    @Override
    public ClassifierBusinessType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierBusinessType> businessType = repo.findById(id);
        if (businessType.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return businessType.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierBusinessType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBusinessType>> add(ClassifierBusinessTypeDTO dto) {
        ClassifierBusinessType businessType = mapper.toEntity(dto);
        repo.save(businessType);
        return ResponseData.success201(businessType);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierBusinessType>> edit(ClassifierBusinessTypeDTO dto) {
        Optional<ClassifierBusinessType> businessType = repo.findById(dto.getId());
        if (businessType.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierBusinessType classifierBusinessType = mapper.toEntity(dto);
        repo.save(classifierBusinessType);
        return ResponseData.success201(classifierBusinessType);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierBusinessType> businessType = repo.findById(id);
        if (businessType.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(businessType.get());
        return ResponseData.success200(true);
    }
}
