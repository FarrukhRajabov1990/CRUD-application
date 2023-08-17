package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierAreaDTO;
import uz.soliq.entities.ClassifierArea;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierAreaService {

    ClassifierArea findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierArea>>> getAll();
    ResponseEntity<ResponseData<ClassifierArea>> add(ClassifierAreaDTO dto);
    ResponseEntity<ResponseData<ClassifierArea>> edit(ClassifierAreaDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierArea>>> findBySimpleQuery(Long version, String areaId, String regionId);
}
