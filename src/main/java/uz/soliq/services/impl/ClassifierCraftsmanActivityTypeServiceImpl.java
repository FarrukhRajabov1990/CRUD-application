package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierCraftsmanActivityTypeDTO;
import uz.soliq.entities.ClassifierCraftsmanActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierCraftsmanActivityTypeMapper;
import uz.soliq.repositories.ClassifierCraftsmanActivityTypeRepo;
import uz.soliq.services.ClassifierCraftsmanActivityTypeService;
import uz.soliq.specifications.CraftsmanActivityType;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierCraftsmanActivityTypeServiceImpl implements ClassifierCraftsmanActivityTypeService {

    private final ClassifierCraftsmanActivityTypeRepo repo;
    private final ClassifierCraftsmanActivityTypeMapper mapper;
    private final CraftsmanActivityType querySearch;

    @Override
    public ClassifierCraftsmanActivityType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierCraftsmanActivityType> activityType = repo.findById(id);
        if (activityType.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return activityType.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> add(
            ClassifierCraftsmanActivityTypeDTO dto) {
        ClassifierCraftsmanActivityType activityType = mapper.toEntity(dto);
        repo.save(activityType);
        return ResponseData.success201(activityType);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> edit(
            ClassifierCraftsmanActivityTypeDTO dto) {
        Optional<ClassifierCraftsmanActivityType> typeOptional = repo.findById(dto.getId());
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierCraftsmanActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierCraftsmanActivityType> type = repo.findById(id);
        if (type.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(type.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> findBySimpleQuery(
            String code, String name, String updatedBy) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, updatedBy));
    }
}
