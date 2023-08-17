package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierProductDTO;
import uz.soliq.entities.ClassifierProduct;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierProductService {

    ClassifierProduct findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierProduct>>> getAll();
    ResponseEntity<ResponseData<ClassifierProduct>> add(ClassifierProductDTO dto);
    ResponseEntity<ResponseData<ClassifierProduct>> edit(ClassifierProductDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierProduct>>> findBySimpleQuery(String createdBy, String deletedBy, String section);
}
