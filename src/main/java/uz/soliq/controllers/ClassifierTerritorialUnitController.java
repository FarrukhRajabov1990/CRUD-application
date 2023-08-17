package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTerritorialUnitDTO;
import uz.soliq.entities.ClassifierTerritorialUnit;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierTerritorialUnitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierTerritorialUnit")
public class ClassifierTerritorialUnitController {

    private final ClassifierTerritorialUnitService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierTerritorialUnit get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierTerritorialUnit>> add(
            @RequestBody ClassifierTerritorialUnitDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierTerritorialUnit>> edit(
            @RequestBody ClassifierTerritorialUnitDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{code}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierTerritorialUnit>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(code, name, version);
    }

}
