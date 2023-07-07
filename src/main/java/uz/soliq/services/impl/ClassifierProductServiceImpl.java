package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosTerritorialLevelDTO;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierArgosTerritorialLevelMapper;
import uz.soliq.repositories.ClassifierArgosTerritorialLevelRepo;
import uz.soliq.services.ClassifierArgosTerritorialLevelService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierArgosTerritorialLevelServiceImpl implements ClassifierArgosTerritorialLevelService {

    private final ClassifierArgosTerritorialLevelRepo repo;
    private final ClassifierArgosTerritorialLevelMapper mapper;

    @Override
    public ClassifierArgosTerritorialLevel findById(String id) throws CustomNotFoundException {
        Optional<ClassifierArgosTerritorialLevel> level = repo.findById(id);
        if (level.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return level.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierArgosTerritorialLevel>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> add(
            ClassifierArgosTerritorialLevelDTO dto) {
        ClassifierArgosTerritorialLevel level = mapper.toEntity(dto);
        repo.save(level);
        return ResponseData.success201(level);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> edit(
            ClassifierArgosTerritorialLevelDTO dto) {
        Optional<ClassifierArgosTerritorialLevel> levelOptional = repo.findById(dto.getId());
        if (levelOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierArgosTerritorialLevel level = mapper.toEntity(dto);
        repo.save(level);
        return ResponseData.success201(level);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierArgosTerritorialLevel> level = repo.findById(id);
        if (level.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(level.get());
        return ResponseData.success200(true);
    }
}
