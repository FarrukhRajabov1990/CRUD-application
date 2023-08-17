package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaDTO;
import uz.soliq.entities.ClassifierMahalla;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierMahallaService {

    ClassifierMahalla findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierMahalla>>> getAll();
    ResponseEntity<ResponseData<ClassifierMahalla>> add(ClassifierMahallaDTO dto);
    ResponseEntity<ResponseData<ClassifierMahalla>> edit(ClassifierMahallaDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierMahalla>>> findBySimpleQuery(String name, Long code, Long version);
}
