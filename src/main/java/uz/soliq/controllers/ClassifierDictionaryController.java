package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierDictionaryDTO;
import uz.soliq.entities.ClassifierDictionary;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierDictionaryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierDictionary")
public class ClassifierDictionaryController {

    private final ClassifierDictionaryService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierDictionary>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierDictionary get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierDictionary>> add(
            @RequestBody ClassifierDictionaryDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierDictionary>> edit(
            @RequestBody ClassifierDictionaryDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{name}/{nameUzLatn}/{updatedBy}")
    public ResponseEntity<ResponseData<List<ClassifierDictionary>>> getAllBySimpleQuery(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "nameUzLatn") String nameUzLatn,
            @PathVariable(value = "updatedBy") String updatedBy) {
        return service.findBySimpleQuery(name, nameUzLatn, updatedBy);
    }

}
