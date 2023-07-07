package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDehkanFarmActivityTypeDTO;
import uz.soliq.entities.ClassifierDehkanFarmActivityType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierDehkanFarmActivityTypeService {


    ClassifierDehkanFarmActivityType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierDehkanFarmActivityType>>> getAll();
    ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> add(ClassifierDehkanFarmActivityTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> edit(ClassifierDehkanFarmActivityTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
