package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosTerritorialLevelDTO;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierArgosTerritorialLevelService {

    ClassifierArgosTerritorialLevel findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierArgosTerritorialLevel>>> getAll();
    ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> add(ClassifierArgosTerritorialLevelDTO dto);
    ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> edit(ClassifierArgosTerritorialLevelDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierArgosTerritorialLevel>>> findBySimpleQuery(String createdBy, String deletedBy, String updatedBy);
}
