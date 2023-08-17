package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTerritorialUnitDTO;
import uz.soliq.entities.ClassifierTerritorialUnit;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierTerritorialUnitService {

    ClassifierTerritorialUnit findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> getAll();
    ResponseEntity<ResponseData<ClassifierTerritorialUnit>> add(ClassifierTerritorialUnitDTO dto);
    ResponseEntity<ResponseData<ClassifierTerritorialUnit>> edit(ClassifierTerritorialUnitDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> findBySimpleQuery(String code, String name, Long version);
}
