package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierRelationDegreeDTO;
import uz.soliq.entities.ClassifierRelationDegree;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierRelationDegreeService {

    ClassifierRelationDegree findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> getAll();
    ResponseEntity<ResponseData<ClassifierRelationDegree>> add(ClassifierRelationDegreeDTO dto);
    ResponseEntity<ResponseData<ClassifierRelationDegree>> edit(ClassifierRelationDegreeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> findBySimpleQuery(String code,  String deletedBy, String name);
}
