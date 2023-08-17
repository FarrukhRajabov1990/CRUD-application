package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaOldStructureDTO;
import uz.soliq.entities.ClassifierGender;
import uz.soliq.entities.ClassifierMahallaOldStructure;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierMahallaOldStructureService {

    ClassifierMahallaOldStructure findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierMahallaOldStructure>>> getAll();
    ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> add(ClassifierMahallaOldStructureDTO dto);
    ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> edit(ClassifierMahallaOldStructureDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierGender>>> findBySimpleQuery(Integer code, String name, Long version);
}
