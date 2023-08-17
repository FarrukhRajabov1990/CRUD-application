package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaDTO;
import uz.soliq.entities.ClassifierMahalla;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierMahallaMapper;
import uz.soliq.repositories.ClassifierMahallaRepo;
import uz.soliq.services.ClassifierMahallaService;
import uz.soliq.specifications.Mahalla;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierMahallaServiceImpl implements ClassifierMahallaService {

    private final ClassifierMahallaRepo repo;
    private final ClassifierMahallaMapper mapper;
    private final Mahalla querySearch;

    @Override
    public ClassifierMahalla findById(String id) throws CustomNotFoundException {
        Optional<ClassifierMahalla> mahallaOptional = repo.findById(id);
        if (mahallaOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return mahallaOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierMahalla>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierMahalla>> add(ClassifierMahallaDTO dto) {
        ClassifierMahalla mahalla = mapper.toEntity(dto);
        repo.save(mahalla);
        return ResponseData.success201(mahalla);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierMahalla>> edit(ClassifierMahallaDTO dto) {
        Optional<ClassifierMahalla> mahallaOptional = repo.findById(dto.getId());
        if (mahallaOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierMahalla mahalla = mapper.toEntity(dto);
        repo.save(mahalla);
        return ResponseData.success201(mahalla);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierMahalla> mahallaOptional = repo.findById(id);
        if (mahallaOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(mahallaOptional.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierMahalla>>> findBySimpleQuery(
            String name, Long code, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(name, code, version));
    }
}
