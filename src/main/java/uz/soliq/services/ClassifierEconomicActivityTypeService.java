package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBusinessTypeDTO;
import uz.soliq.entities.ClassifierBusinessType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierBusinessTypeService {

    ClassifierBusinessType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierBusinessType>>> getAll();
    ResponseEntity<ResponseData<ClassifierBusinessType>> add(ClassifierBusinessTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierBusinessType>> edit(ClassifierBusinessTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
