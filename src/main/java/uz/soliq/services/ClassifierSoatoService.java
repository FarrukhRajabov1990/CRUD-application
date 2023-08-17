package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSoatoDTO;
import uz.soliq.entities.ClassifierSoato;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierSoatoService {


    ClassifierSoato findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierSoato>>> getAll();
    ResponseEntity<ResponseData<ClassifierSoato>> add(ClassifierSoatoDTO dto);
    ResponseEntity<ResponseData<ClassifierSoato>> edit(ClassifierSoatoDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
    ResponseEntity<ResponseData<List<ClassifierSoato>>> findBySimpleQuery(String createdBy,  String deletedBy, String name);
}
