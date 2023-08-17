package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankReasonStatusDTO;
import uz.soliq.entities.ClassifierBankReasonStatus;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierBankReasonStatusService {

    ClassifierBankReasonStatus findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> getAll();
    ResponseEntity<ResponseData<ClassifierBankReasonStatus>> add(ClassifierBankReasonStatusDTO dto);
    ResponseEntity<ResponseData<ClassifierBankReasonStatus>> edit(ClassifierBankReasonStatusDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> findBySimpleQuery(
            String code, String name, Long version);
}
