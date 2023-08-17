package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierCraftsmanActivityTypeDTO;
import uz.soliq.entities.ClassifierCraftsmanActivityType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierCraftsmanActivityTypeService {

    ClassifierCraftsmanActivityType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> getAll();
    ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> add(ClassifierCraftsmanActivityTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> edit(ClassifierCraftsmanActivityTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> findBySimpleQuery(
            String code, String name, String updatedBy);
}
