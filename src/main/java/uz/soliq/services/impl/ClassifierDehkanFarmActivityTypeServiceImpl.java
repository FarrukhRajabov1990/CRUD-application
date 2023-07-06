package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDehkanFarmActivityTypeDTO;
import uz.soliq.entities.ClassifierDehkanFarmActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierDehkanFarmActivityTypeMapper;
import uz.soliq.repositories.ClassifierDehkanFarmActivityTypeRepo;
import uz.soliq.services.ClassifierDehkanFarmActivityTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierDehkanFarmActivityTypeServiceImpl implements ClassifierDehkanFarmActivityTypeService {

    private final ClassifierDehkanFarmActivityTypeRepo repo;
    private final ClassifierDehkanFarmActivityTypeMapper mapper;

    @Override
    public ClassifierDehkanFarmActivityType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierDehkanFarmActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return typeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierDehkanFarmActivityType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> add
            (ClassifierDehkanFarmActivityTypeDTO dto) {
        ClassifierDehkanFarmActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> edit
            (ClassifierDehkanFarmActivityTypeDTO dto) {
        Optional<ClassifierDehkanFarmActivityType> typeOptional = repo.findById(dto.getId());
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierDehkanFarmActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierDehkanFarmActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(typeOptional.get());
        return ResponseData.success200(true);
    }
}
