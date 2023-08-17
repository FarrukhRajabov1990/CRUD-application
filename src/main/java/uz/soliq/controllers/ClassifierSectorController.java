package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSectorDTO;
import uz.soliq.entities.ClassifierSector;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierSectorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierSector")
public class ClassifierSectorController {

    private final ClassifierSectorService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierSector>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierSector get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierSector>> add(
            @RequestBody ClassifierSectorDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierSector>> edit(@RequestBody ClassifierSectorDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{createdBy}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierSector>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(createdBy, name, version);
    }

}
