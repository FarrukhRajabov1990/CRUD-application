package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierRelationDegreeDTO;
import uz.soliq.entities.ClassifierRelationDegree;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierRelationDegreeMapper;
import uz.soliq.repositories.ClassifierRelationDegreeRepo;
import uz.soliq.services.ClassifierRelationDegreeService;
import uz.soliq.specifications.RelationDegree;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierRelationDegreeServiceImpl implements ClassifierRelationDegreeService {

    private final ClassifierRelationDegreeRepo repo;
    private final ClassifierRelationDegreeMapper mapper;
    private final RelationDegree querySearch;

    @Override
    public ClassifierRelationDegree findById(String id) throws CustomNotFoundException {
        Optional<ClassifierRelationDegree> degree = repo.findById(id);
        if (degree.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return degree.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierRelationDegree>> add(ClassifierRelationDegreeDTO dto) {
        ClassifierRelationDegree degree = mapper.toEntity(dto);
        repo.save(degree);
        return ResponseData.success201(degree);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierRelationDegree>> edit(ClassifierRelationDegreeDTO dto) {
        Optional<ClassifierRelationDegree> degreeOptional = repo.findById(dto.getId());
        if (degreeOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierRelationDegree degree = mapper.toEntity(dto);
        repo.save(degree);
        return ResponseData.success201(degree);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierRelationDegree> degree = repo.findById(id);
        if (degree.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(degree.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> findBySimpleQuery(
            String code,  String deletedBy, String name) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, deletedBy, name));
    }
}
