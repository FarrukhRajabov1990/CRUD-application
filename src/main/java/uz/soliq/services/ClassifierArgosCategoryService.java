package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosCategoryDTO;
import uz.soliq.entities.ClassifierArgosCategory;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierArgosCategoryService {

    ClassifierArgosCategory findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> getAll();
    ResponseEntity<ResponseData<ClassifierArgosCategory>> add(ClassifierArgosCategoryDTO dto);
    ResponseEntity<ResponseData<ClassifierArgosCategory>> edit(ClassifierArgosCategoryDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> findBySimpleQuery(String code, String name, Long version);
}
