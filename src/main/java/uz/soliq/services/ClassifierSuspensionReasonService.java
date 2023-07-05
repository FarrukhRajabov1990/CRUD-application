package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSuspensionReasonDTO;
import uz.soliq.entities.ClassifierSuspensionReason;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierSuspensionReasonService {

    ClassifierSuspensionReason findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> getAll();
    ResponseEntity<ResponseData<ClassifierSuspensionReason>> add(ClassifierSuspensionReasonDTO dto);
    ResponseEntity<ResponseData<ClassifierSuspensionReason>> edit(ClassifierSuspensionReasonDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> findBySimpleQuery(Integer code, String name, Long version);
}
