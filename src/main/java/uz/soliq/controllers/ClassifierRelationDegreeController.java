package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierRelationDegreeDTO;
import uz.soliq.entities.ClassifierRelationDegree;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierRelationDegreeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierRelationDegree")
public class ClassifierRelationDegreeController {

    private final ClassifierRelationDegreeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierRelationDegree get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierRelationDegree>> add(
            @RequestBody ClassifierRelationDegreeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierRelationDegree>> edit(
            @RequestBody ClassifierRelationDegreeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{code}/{deletedBy}/{name}")
    public ResponseEntity<ResponseData<List<ClassifierRelationDegree>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "name") String name) {
        return service.findBySimpleQuery(code, deletedBy, name);
    }
}
