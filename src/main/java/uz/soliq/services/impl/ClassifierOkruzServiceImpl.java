package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierOkruzDTO;
import uz.soliq.entities.ClassifierOkruz;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierOkruzMapper;
import uz.soliq.repositories.ClassifierOkruzRepo;
import uz.soliq.services.ClassifierOkruzService;
import uz.soliq.specifications.Okruz;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierOkruzServiceImpl implements ClassifierOkruzService {

    private final ClassifierOkruzRepo repo;
    private final ClassifierOkruzMapper mapper;
    private final Okruz querySearch;

    @Override
    public ClassifierOkruz findById(String id) throws CustomNotFoundException {
        Optional<ClassifierOkruz> okruzOptional = repo.findById(id);
        if (okruzOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return okruzOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierOkruz>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierOkruz>> add(ClassifierOkruzDTO dto) {
        ClassifierOkruz okruz = mapper.toEntity(dto);
        repo.save(okruz);
        return ResponseData.success201(okruz);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierOkruz>> edit(ClassifierOkruzDTO dto) {
        Optional<ClassifierOkruz> okruzOptional = repo.findById(dto.getId());
        if (okruzOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierOkruz okruz = mapper.toEntity(dto);
        repo.save(okruz);
        return ResponseData.success201(okruz);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierOkruz> okruzOptional = repo.findById(id);
        if (okruzOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(okruzOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierOkruz>>> findBySimpleQuery(
            String createdBy, String deletedBy, String okruzCode) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, deletedBy, okruzCode));
    }
}
