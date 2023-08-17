package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierZipCodeDTO;
import uz.soliq.entities.ClassifierZipCode;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierZipCodeService {

    ClassifierZipCode findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierZipCode>>> getAll();
    ResponseEntity<ResponseData<ClassifierZipCode>> add(ClassifierZipCodeDTO dto);
    ResponseEntity<ResponseData<ClassifierZipCode>> edit(ClassifierZipCodeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierZipCode>>> findBySimpleQuery(String createdBy, String deletedBy, String updatedBy);
}
