package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierLegalFormsDTO;
import uz.soliq.entities.ClassifierLegalForms;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierLegalFormsService {

    ClassifierLegalForms findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierLegalForms>>> getAll();
    ResponseEntity<ResponseData<ClassifierLegalForms>> add(ClassifierLegalFormsDTO dto);
    ResponseEntity<ResponseData<ClassifierLegalForms>> edit(ClassifierLegalFormsDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierLegalForms>>> findBySimpleQuery(
            String createdBy, String deletedBy, String name);
}
