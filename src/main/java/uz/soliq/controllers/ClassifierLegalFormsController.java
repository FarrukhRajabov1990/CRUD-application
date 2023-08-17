package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierLegalFormsDTO;
import uz.soliq.entities.ClassifierLegalForms;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierLegalFormsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierLegalForms")
public class ClassifierLegalFormsController {

    private final ClassifierLegalFormsService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierLegalForms>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierLegalForms get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierLegalForms>> add(
            @RequestBody ClassifierLegalFormsDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierLegalForms>> edit(
            @RequestBody ClassifierLegalFormsDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{createdBy}/{deletedBy}/{name}")
    public ResponseEntity<ResponseData<List<ClassifierLegalForms>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy,
            @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "name") String name) {
        return service.findBySimpleQuery(createdBy, deletedBy, name);
    }

}
