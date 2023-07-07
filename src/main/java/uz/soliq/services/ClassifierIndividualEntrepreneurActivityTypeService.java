package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierIndividualEntrepreneurActivityTypeDTO;
import uz.soliq.entities.ClassifierIndividualEntrepreneurActivityType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierIndividualEntrepreneurActivityTypeService {


    ClassifierIndividualEntrepreneurActivityType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierIndividualEntrepreneurActivityType>>> getAll();
    ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>> add
            (ClassifierIndividualEntrepreneurActivityTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>> edit
            (ClassifierIndividualEntrepreneurActivityTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
