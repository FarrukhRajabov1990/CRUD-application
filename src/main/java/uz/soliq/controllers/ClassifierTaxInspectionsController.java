package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxInspectionsDTO;
import uz.soliq.entities.ClassifierTaxInspections;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierTaxInspectionsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierTaxInspections")
public class ClassifierTaxInspectionsController {

    private final ClassifierTaxInspectionsService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierTaxInspections>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierTaxInspections get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierTaxInspections>> add(@RequestBody ClassifierTaxInspectionsDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierTaxInspections>> edit(@RequestBody ClassifierTaxInspectionsDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{name}/{adres}/{account}")
    public ResponseEntity<ResponseData<List<ClassifierTaxInspections>>> getAllBySimpleQuery(
            @PathVariable(value = "name") String name, @PathVariable(value = "adres") String adres,
            @PathVariable(value = "account") String account) {
        return service.findBySimpleQuery(name, adres, account);
    }
}
