package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierEconomicActivityTypeDTO;
import uz.soliq.entities.ClassifierEconomicActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierEconomicActivityTypeMapper;
import uz.soliq.repositories.ClassifierEconomicActivityTypeRepo;
import uz.soliq.services.ClassifierEconomicActivityTypeService;
import uz.soliq.specifications.EconomicActivityType;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierEconomicActivityTypeServiceImpl implements ClassifierEconomicActivityTypeService {


    private final ClassifierEconomicActivityTypeRepo repo;
    private final ClassifierEconomicActivityTypeMapper mapper;
    private final EconomicActivityType querySearch;

    @Override
    public ClassifierEconomicActivityType findById(String id) throws CustomNotFoundException {
        Optional<ClassifierEconomicActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return typeOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierEconomicActivityType>> add(
            ClassifierEconomicActivityTypeDTO dto) {
        ClassifierEconomicActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierEconomicActivityType>> edit(
            ClassifierEconomicActivityTypeDTO dto) {
        Optional<ClassifierEconomicActivityType> typeOptional = repo.findById(dto.getId());
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierEconomicActivityType type = mapper.toEntity(dto);
        repo.save(type);
        return ResponseData.success201(type);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierEconomicActivityType> typeOptional = repo.findById(id);
        if (typeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(typeOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> findBySimpleQuery(
            String createdBy,  String deletedBy, String updatedBy) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, deletedBy, updatedBy));
    }
}
