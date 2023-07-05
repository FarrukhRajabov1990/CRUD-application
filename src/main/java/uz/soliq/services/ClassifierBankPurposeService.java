package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankPurposeDTO;
import uz.soliq.entities.ClassifierBankPurpose;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierBankPurposeService {

    ClassifierBankPurpose findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierBankPurpose>>> getAll();
    ResponseEntity<ResponseData<ClassifierBankPurpose>> add(ClassifierBankPurposeDTO dto);
    ResponseEntity<ResponseData<ClassifierBankPurpose>> edit(ClassifierBankPurposeDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
