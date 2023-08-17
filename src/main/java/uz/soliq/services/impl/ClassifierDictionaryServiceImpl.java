package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDictionaryDTO;
import uz.soliq.entities.ClassifierDictionary;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierDictionaryMapper;
import uz.soliq.repositories.ClassifierDictionaryRepo;
import uz.soliq.services.ClassifierDictionaryService;
import uz.soliq.specifications.Dictionary;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierDictionaryServiceImpl implements ClassifierDictionaryService {

    private final ClassifierDictionaryRepo repo;
    private final ClassifierDictionaryMapper mapper;
    private final Dictionary querySearch;

    @Override
    public ClassifierDictionary findById(String id) throws CustomNotFoundException {
        Optional<ClassifierDictionary> dictionary = repo.findById(id);
        if (dictionary.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return dictionary.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierDictionary>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierDictionary>> add(ClassifierDictionaryDTO dto) {
        ClassifierDictionary dictionary = mapper.toEntity(dto);
        repo.save(dictionary);
        return ResponseData.success201(dictionary);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierDictionary>> edit(ClassifierDictionaryDTO dto) {
        Optional<ClassifierDictionary> dictionaryOptional = repo.findById(dto.getId());
        if (dictionaryOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierDictionary dictionary = mapper.toEntity(dto);
        repo.save(dictionary);
        return ResponseData.success201(dictionary);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierDictionary> dictionary = repo.findById(id);
        if (dictionary.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(dictionary.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierDictionary>>> findBySimpleQuery(
            String name, String nameUzLatn, String updatedBy) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(name, nameUzLatn, updatedBy));
    }
}
