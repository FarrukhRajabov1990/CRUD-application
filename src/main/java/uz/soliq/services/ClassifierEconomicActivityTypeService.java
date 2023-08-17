package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierEconomicActivityTypeDTO;
import uz.soliq.entities.ClassifierEconomicActivityType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierEconomicActivityTypeService {

    ClassifierEconomicActivityType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> getAll();
    ResponseEntity<ResponseData<ClassifierEconomicActivityType>> add(ClassifierEconomicActivityTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierEconomicActivityType>> edit(ClassifierEconomicActivityTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> findBySimpleQuery(String createdBy, String deletedBy, String updatedBy);
}
