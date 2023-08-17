package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankPurposeDTO;
import uz.soliq.entities.ClassifierBankPurpose;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierBankPurposeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierBankPurpose")
public class ClassifierBankPurposeController {

    private final ClassifierBankPurposeService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierBankPurpose>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierBankPurpose get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierBankPurpose>> add(@RequestBody ClassifierBankPurposeDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierBankPurpose>> edit(@RequestBody ClassifierBankPurposeDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{name}/{updatedBy}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierBankPurpose>>> getAllBySimpleQuery(
            @PathVariable(value = "name") String name, @PathVariable(value = "updatedBy") String updatedBy,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(name, updatedBy, version);
    }
}
