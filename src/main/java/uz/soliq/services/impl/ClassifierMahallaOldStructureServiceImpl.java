package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaOldStructureDTO;
import uz.soliq.entities.ClassifierGender;
import uz.soliq.entities.ClassifierMahallaOldStructure;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierMahallaOldStructureMapper;
import uz.soliq.repositories.ClassifierMahallaOldStructureRepo;
import uz.soliq.services.ClassifierMahallaOldStructureService;
import uz.soliq.specifications.GenderSearch;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierMahallaOldStructureServiceImpl implements ClassifierMahallaOldStructureService {

    private final ClassifierMahallaOldStructureRepo repo;
    private final ClassifierMahallaOldStructureMapper mapper;
    private final GenderSearch querySearch;

    @Override
    public ClassifierMahallaOldStructure findById(String id) throws CustomNotFoundException {
        Optional<ClassifierMahallaOldStructure> reasonOptional = repo.findById(id);
        if (reasonOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return reasonOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierMahallaOldStructure>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> add(ClassifierMahallaOldStructureDTO dto) {
        ClassifierMahallaOldStructure oldStructure = mapper.toEntity(dto);
        repo.save(oldStructure);
        return ResponseData.success201(oldStructure);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> edit(ClassifierMahallaOldStructureDTO dto) {
        Optional<ClassifierMahallaOldStructure> oldStructure = repo.findById(dto.getId());
        if (oldStructure.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierMahallaOldStructure classifierMahallaOldStructure = mapper.toEntity(dto);
        repo.save(classifierMahallaOldStructure);
        return ResponseData.success201(classifierMahallaOldStructure);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierMahallaOldStructure> oldStructureOptional = repo.findById(id);
        if (oldStructureOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(oldStructureOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierGender>>> findBySimpleQuery(
            Integer code, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, version));
    }
}
