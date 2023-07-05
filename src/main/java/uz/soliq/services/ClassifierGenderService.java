package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierGenderDTO;
import uz.soliq.entities.ClassifierGender;
import uz.soliq.entities.ClassifierSuspensionReason;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierGenderService {

    ClassifierGender findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierGender>>> getAll();
    ResponseEntity<ResponseData<ClassifierGender>> add(ClassifierGenderDTO dto);
    ResponseEntity<ResponseData<ClassifierGender>> edit(ClassifierGenderDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierGender>>> findBySimpleQuery(Integer code, String name, Long version);
}
