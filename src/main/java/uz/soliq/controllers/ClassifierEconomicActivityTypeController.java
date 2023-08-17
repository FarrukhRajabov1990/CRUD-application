package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierEconomicActivityTypeDTO;
import uz.soliq.entities.ClassifierEconomicActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierEconomicActivityTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierEconomicActivityType")
public class ClassifierEconomicActivityTypeController {

    private final ClassifierEconomicActivityTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierEconomicActivityType get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierEconomicActivityType>> add(
            @RequestBody ClassifierEconomicActivityTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierEconomicActivityType>> edit(
            @RequestBody ClassifierEconomicActivityTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{createdBy}/{deletedBy}/{updatedBy}")
    public ResponseEntity<ResponseData<List<ClassifierEconomicActivityType>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy, @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "updatedBy") String updatedBy) {
        return service.findBySimpleQuery(createdBy, deletedBy, updatedBy);
    }
}
