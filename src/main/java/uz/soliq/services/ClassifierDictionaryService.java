package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDictionaryDTO;
import uz.soliq.entities.ClassifierDictionary;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierDictionaryService {

    ClassifierDictionary findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierDictionary>>> getAll();
    ResponseEntity<ResponseData<ClassifierDictionary>> add(ClassifierDictionaryDTO dto);
    ResponseEntity<ResponseData<ClassifierDictionary>> edit(ClassifierDictionaryDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierDictionary>>> findBySimpleQuery(
            String name, String nameUzLatn, String updatedBy);
}
