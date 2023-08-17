package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSectorDTO;
import uz.soliq.entities.ClassifierSector;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierSectorMapper;
import uz.soliq.repositories.ClassifierSectorRepo;
import uz.soliq.services.ClassifierSectorService;
import uz.soliq.specifications.Sector;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierSectorServiceImpl implements ClassifierSectorService {

    private final ClassifierSectorRepo repo;
    private final ClassifierSectorMapper mapper;
    private final Sector querySearch;

    @Override
    public ClassifierSector findById(String id) throws CustomNotFoundException {
        Optional<ClassifierSector> sector = repo.findById(id);
        if (sector.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return sector.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierSector>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSector>> add(ClassifierSectorDTO dto) {
        ClassifierSector sector = mapper.toEntity(dto);
        repo.save(sector);
        return ResponseData.success201(sector);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSector>> edit(ClassifierSectorDTO dto) {
        Optional<ClassifierSector> sectorOptional = repo.findById(dto.getId());
        if (sectorOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierSector sector = mapper.toEntity(dto);
        repo.save(sector);
        return ResponseData.success201(sector);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierSector> sector = repo.findById(id);
        if (sector.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(sector.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierSector>>> findBySimpleQuery(
            String createdBy, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, name, version));
    }
}
