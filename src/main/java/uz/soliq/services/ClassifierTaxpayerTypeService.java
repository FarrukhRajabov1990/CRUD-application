package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeDTO;
import uz.soliq.entities.ClassifierTaxpayerType;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierTaxpayerTypeService {

    ClassifierTaxpayerType findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierTaxpayerType>>> getAll();
    ResponseEntity<ResponseData<ClassifierTaxpayerType>> add(ClassifierTaxpayerTypeDTO dto);
    ResponseEntity<ResponseData<ClassifierTaxpayerType>> edit(ClassifierTaxpayerTypeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
