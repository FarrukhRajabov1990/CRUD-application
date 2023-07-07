package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosTerritorialLevelDTO;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierArgosTerritorialLevelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierArgosTerritorialLevel")
public class ClassifierArgosTerritorialLevelController {

    private final ClassifierArgosTerritorialLevelService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierArgosTerritorialLevel>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierArgosTerritorialLevel get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> add(
            @RequestBody ClassifierArgosTerritorialLevelDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierArgosTerritorialLevel>> edit(
            @RequestBody ClassifierArgosTerritorialLevelDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
