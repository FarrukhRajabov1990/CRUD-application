package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierZipCodeDTO;
import uz.soliq.entities.ClassifierZipCode;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierZipCodeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierZipCode")
public class ClassifierZipCodeController {

    private final ClassifierZipCodeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierZipCode>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierZipCode get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierZipCode>> add(@RequestBody ClassifierZipCodeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierZipCode>> edit(@RequestBody ClassifierZipCodeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{createdBy}/{deletedBy}/{updatedBy}")
    public ResponseEntity<ResponseData<List<ClassifierZipCode>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy, @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "updatedBy") String updatedBy) {
        return service.findBySimpleQuery(createdBy, deletedBy, updatedBy);
    }
}
