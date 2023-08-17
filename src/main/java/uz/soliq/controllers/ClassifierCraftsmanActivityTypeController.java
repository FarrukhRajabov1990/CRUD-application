package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierCraftsmanActivityTypeDTO;
import uz.soliq.entities.ClassifierCraftsmanActivityType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierCraftsmanActivityTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierCraftsmanActivityType")
public class ClassifierCraftsmanActivityTypeController {

    private final ClassifierCraftsmanActivityTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierCraftsmanActivityType get(
            @PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> add(
            @RequestBody ClassifierCraftsmanActivityTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierCraftsmanActivityType>> edit(
            @RequestBody ClassifierCraftsmanActivityTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{code}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierCraftsmanActivityType>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") String updatedBy) {
        return service.findBySimpleQuery(code, name, updatedBy);
    }

}
