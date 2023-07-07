package uz.soliq.services;

import org.springframework.http.ResponseEntity;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankDTO;
import uz.soliq.entities.ClassifierBank;
import uz.soliq.exceptions.CustomNotFoundException;

import java.util.List;

public interface ClassifierBankService {


    ClassifierBank findById(String id) throws CustomNotFoundException;
    ResponseEntity<ResponseData<List<ClassifierBank>>> getAll();
    ResponseEntity<ResponseData<ClassifierBank>> add(ClassifierBankDTO dto);
    ResponseEntity<ResponseData<ClassifierBank>> edit(ClassifierBankDTO dto);
    ResponseEntity<ResponseData<Boolean>> delete(String id);
}
