package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTerritorialUnitDTO;
import uz.soliq.entities.ClassifierTerritorialUnit;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierTerritorialUnitMapper;
import uz.soliq.repositories.ClassifierTerritorialUnitRepo;
import uz.soliq.services.ClassifierTerritorialUnitService;
import uz.soliq.specifications.TerritorialUnit;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierTerritorialUnitServiceImpl implements ClassifierTerritorialUnitService {

    private final ClassifierTerritorialUnitRepo repo;
    private final ClassifierTerritorialUnitMapper mapper;
    private final TerritorialUnit querySearch;

    @Override
    public ClassifierTerritorialUnit findById(String id) throws CustomNotFoundException {
        Optional<ClassifierTerritorialUnit> unit = repo.findById(id);
        if (unit.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return unit.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTerritorialUnit>> add(ClassifierTerritorialUnitDTO dto) {
        ClassifierTerritorialUnit unit = mapper.toEntity(dto);
        repo.save(unit);
        return ResponseData.success201(unit);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierTerritorialUnit>> edit(ClassifierTerritorialUnitDTO dto) {
        Optional<ClassifierTerritorialUnit> unitOptional = repo.findById(dto.getId());
        if (unitOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierTerritorialUnit unit = mapper.toEntity(dto);
        repo.save(unit);
        return ResponseData.success201(unit);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierTerritorialUnit> unit = repo.findById(id);
        if (unit.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(unit.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> findBySimpleQuery(
            String code, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, version));
    }
}
