package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierArgosCategoryDTO;
import uz.soliq.entities.ClassifierArgosCategory;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierArgosCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierArgosCategory")
public class ClassifierArgosCategoryController {

    private final ClassifierArgosCategoryService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierArgosCategory get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierArgosCategory>> add(@RequestBody ClassifierArgosCategoryDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierArgosCategory>> edit(@RequestBody ClassifierArgosCategoryDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{code}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierArgosCategory>>> getAllBySimpleQuery(
            @PathVariable(value = "code") String code, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(code, name, version);
    }

}
