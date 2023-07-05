package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierTaxpayerTypeDTO;
import uz.soliq.entities.ClassifierTaxpayerType;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierTaxpayerTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierTaxpayerType")
public class ClassifierTaxpayerTypeController {

    private final ClassifierTaxpayerTypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierTaxpayerType>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierTaxpayerType get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierTaxpayerType>> add(@RequestBody ClassifierTaxpayerTypeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierTaxpayerType>> edit(@RequestBody ClassifierTaxpayerTypeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
