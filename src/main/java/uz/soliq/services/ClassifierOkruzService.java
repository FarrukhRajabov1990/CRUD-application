package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierOkruzDTO;
import uz.soliq.entities.ClassifierOkruz;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierOkruzService {

    ClassifierOkruz findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierOkruz>>> getAll();
    ResponseEntity<ResponseData<ClassifierOkruz>> add(ClassifierOkruzDTO dto);
    ResponseEntity<ResponseData<ClassifierOkruz>> edit(ClassifierOkruzDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierOkruz>>> findBySimpleQuery(
            String createdBy, String deletedBy, String okruzCode);
}
