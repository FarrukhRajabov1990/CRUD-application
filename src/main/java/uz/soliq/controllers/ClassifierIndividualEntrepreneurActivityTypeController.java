package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierIndividualEntrepreneurActivityTypeDTO;
import uz.soliq.entities.ClassifierIndividualEntrepreneurActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierIndividualEntrepreneurActivityTypeService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierIndividualEntrepreneurActivityType")
public class ClassifierIndividualEntrepreneurActivityTypeController {

    private final ClassifierIndividualEntrepreneurActivityTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierIndividualEntrepreneurActivityType>>> getAll() {
        return service.getAll();
    }


    @GetMapping("/get/{id}")
    public ClassifierIndividualEntrepreneurActivityType get(@PathVariable(value = "id") String id)
            throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>> add(
            @RequestBody ClassifierIndividualEntrepreneurActivityTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierIndividualEntrepreneurActivityType>> edit(
            @RequestBody ClassifierIndividualEntrepreneurActivityTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{code}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierIndividualEntrepreneurActivityType>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(code, name, version);
    }
}
