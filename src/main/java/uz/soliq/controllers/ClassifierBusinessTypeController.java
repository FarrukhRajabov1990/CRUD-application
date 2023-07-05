package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBusinessTypeDTO;
import uz.soliq.entities.ClassifierBusinessType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierBusinessTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierBusinessType")
public class ClassifierBusinessTypeController {

    private final ClassifierBusinessTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierBusinessType>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierBusinessType get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierBusinessType>> add(@RequestBody ClassifierBusinessTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierBusinessType>> edit(@RequestBody ClassifierBusinessTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
