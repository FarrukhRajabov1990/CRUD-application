package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeSelfEmployedDTO;
import uz.soliq.entities.ClassifierTaxpayerTypeSelfEmployed;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierTaxpayerTypeSelfEmployedService {


    ClassifierTaxpayerTypeSelfEmployed findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierTaxpayerTypeSelfEmployed>>> getAll();
    ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> add(
            ClassifierTaxpayerTypeSelfEmployedDTO dto);
    ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> edit(
            ClassifierTaxpayerTypeSelfEmployedDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
