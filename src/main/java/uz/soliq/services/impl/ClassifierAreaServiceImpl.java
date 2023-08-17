package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierAreaDTO;
import uz.soliq.entities.ClassifierArea;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierAreaMapper;
import uz.soliq.repositories.ClassifierAreaRepo;
import uz.soliq.services.ClassifierAreaService;
import uz.soliq.specifications.Area;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierAreaServiceImpl implements ClassifierAreaService {

    private final ClassifierAreaRepo repo;
    private final ClassifierAreaMapper mapper;
    private final Area querySearch;

    @Override
    public ClassifierArea findById(String id) throws CustomNotFoundException {
        Optional<ClassifierArea> areaOptional = repo.findById(id);
        if (areaOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return areaOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierArea>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArea>> add(ClassifierAreaDTO dto) {
        ClassifierArea area = mapper.toEntity(dto);
        repo.save(area);
        return ResponseData.success201(area);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArea>> edit(ClassifierAreaDTO dto) {
        Optional<ClassifierArea> areaOptional = repo.findById(dto.getId());
        if (areaOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierArea area = mapper.toEntity(dto);
        repo.save(area);
        return ResponseData.success201(area);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierArea> areaOptional = repo.findById(id);
        if (areaOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(areaOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierArea>>> findBySimpleQuery(
            Long version, String areaId, String regionId) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(version, areaId, regionId));
    }
}
