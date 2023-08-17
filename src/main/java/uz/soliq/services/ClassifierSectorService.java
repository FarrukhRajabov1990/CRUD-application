package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSectorDTO;
import uz.soliq.entities.ClassifierSector;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierSectorService {

    ClassifierSector findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierSector>>> getAll();
    ResponseEntity<ResponseData<ClassifierSector>> add(ClassifierSectorDTO dto);
    ResponseEntity<ResponseData<ClassifierSector>> edit(ClassifierSectorDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierSector>>> findBySimpleQuery(
            String createdBy, String name, Long version);
}
