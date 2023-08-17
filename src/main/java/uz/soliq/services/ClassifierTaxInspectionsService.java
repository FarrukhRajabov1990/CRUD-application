package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxInspectionsDTO;
import uz.soliq.entities.ClassifierGender;
import uz.soliq.entities.ClassifierTaxInspections;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierTaxInspectionsService {

    ClassifierTaxInspections findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierTaxInspections>>> getAll();
    ResponseEntity<ResponseData<ClassifierTaxInspections>> add(ClassifierTaxInspectionsDTO dto);
    ResponseEntity<ResponseData<ClassifierTaxInspections>> edit(ClassifierTaxInspectionsDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierTaxInspections>>> findBySimpleQuery(String name, String adres, String account);
}
