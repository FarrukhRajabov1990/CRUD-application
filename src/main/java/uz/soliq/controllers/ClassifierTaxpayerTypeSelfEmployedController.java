package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeSelfEmployedDTO;
import uz.soliq.entities.ClassifierTaxpayerTypeSelfEmployed;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierTaxpayerTypeSelfEmployedService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierTaxpayerTypeSelfEmployed")
public class ClassifierTaxpayerTypeSelfEmployedController {

    private final ClassifierTaxpayerTypeSelfEmployedService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerTypeSelfEmployed>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierTaxpayerTypeSelfEmployed get(@PathVariable(value = "id") String id)
            throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> add(
            @RequestBody ClassifierTaxpayerTypeSelfEmployedDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierTaxpayerTypeSelfEmployed>> edit(
            @RequestBody ClassifierTaxpayerTypeSelfEmployedDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{name}/{updatedBy}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerTypeSelfEmployed>>> getAllBySimpleQuery(
            @PathVariable(value = "name") String name, @PathVariable(value = "updatedBy") String updatedBy,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(name, updatedBy, version);
    }
}
