package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosCategoryDTO;
import uz.soliq.entities.ClassifierArgosCategory;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierArgosCategoryMapper;
import uz.soliq.repositories.ClassifierArgosCategoryRepo;
import uz.soliq.services.ClassifierArgosCategoryService;
import uz.soliq.specifications.ArgosCategory;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierArgosCategoryServiceImpl implements ClassifierArgosCategoryService {

    private final ClassifierArgosCategoryRepo repo;
    private final ClassifierArgosCategoryMapper mapper;
    private final ArgosCategory querySearch;

    @Override
    public ClassifierArgosCategory findById(String id) throws CustomNotFoundException {
        Optional<ClassifierArgosCategory> category = repo.findById(id);
        if (category.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return category.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArgosCategory>> add(ClassifierArgosCategoryDTO dto) {
        ClassifierArgosCategory argosCategory = mapper.toEntity(dto);
        repo.save(argosCategory);
        return ResponseData.success201(argosCategory);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierArgosCategory>> edit(ClassifierArgosCategoryDTO dto) {
        Optional<ClassifierArgosCategory> category = repo.findById(dto.getId());
        if (category.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierArgosCategory classifierArgosCategory = mapper.toEntity(dto);
        repo.save(classifierArgosCategory);
        return ResponseData.success201(classifierArgosCategory);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierArgosCategory> category = repo.findById(id);
        if (category.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(category.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> findBySimpleQuery(
            String code, String name, Long version) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(code, name, version));
    }
}
