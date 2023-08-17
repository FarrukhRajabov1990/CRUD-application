package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierProductDTO;
import uz.soliq.entities.ClassifierProduct;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierProduct")
public class ClassifierProductController {

    private final ClassifierProductService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierProduct>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierProduct get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierProduct>> add(@RequestBody ClassifierProductDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierProduct>> edit(@RequestBody ClassifierProductDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{createdBy}/{deletedBy}/{section}")
    public ResponseEntity<ResponseData<List<ClassifierProduct>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy, @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "section") String section) {
        return service.findBySimpleQuery(createdBy, deletedBy, section);
    }

}
