package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierIndividualEntrepreneurActivityTypeDTO;
import uz.soliq.entities.ClassifierIndividualEntrepreneurActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierIndividualEntrepreneurActivityTypeMapper;
import uz.soliq.repositories.ClassifierIndividualEntrepreneurActivityTypeRepo;
import uz.soliq.services.ClassifierIndividualEntrepreneurActivityTypeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierIndividualEntrepreneurActivityTypeServiceImpl
        implements ClassifierIndividualEntrepreneurActivityTypeService {

    private final ClassifierIndividualEntrepreneurActivityTypeRepo repo;
    private final ClassifierIndividualEntrepreneurActivityTypeMapper mapper;

    @Override
    public ClassifierIndividualEntrepreneurActivityType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierIndividualEntrepreneurActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return typeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierIndividualEntrepreneurActivityType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>>
    add(ClassifierIndividualEntrepreneurActivityTypeDTO dto) {
        ClassifierIndividualEntrepreneurActivityType area = mapper.toEntity(dto);
        repo.save(area);
        return ResponseData.success201(area);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>>
    edit(ClassifierIndividualEntrepreneurActivityTypeDTO dto) {
        Optional<ClassifierIndividualEntrepreneurActivityType> typeOptional = repo.findById(dto.getId());
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierIndividualEntrepreneurActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierIndividualEntrepreneurActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(typeOptional.get());
        return ResponseData.success200(true);
    }
}
