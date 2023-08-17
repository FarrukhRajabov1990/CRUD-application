package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDehkanFarmActivityTypeDTO;
import uz.soliq.entities.ClassifierDehkanFarmActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierDehkanFarmActivityTypeService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/classifier/dehkan/farmActivityType")
public class ClassifierDehkanFarmActivityTypeController {

    private final ClassifierDehkanFarmActivityTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierDehkanFarmActivityType>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierDehkanFarmActivityType get(@PathVariable(value = "id") String id)
            throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> add(
            @RequestBody ClassifierDehkanFarmActivityTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierDehkanFarmActivityType>> edit(
            @RequestBody ClassifierDehkanFarmActivityTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{code}/{name}/{updatedBy}")
    public ResponseEntity<ResponseData<List<ClassifierDehkanFarmActivityType>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "name") String name,
            @PathVariable(value = "updatedBy") String updatedBy) {
        return service.findBySimpleQuery(code, name, updatedBy);
    }
}
