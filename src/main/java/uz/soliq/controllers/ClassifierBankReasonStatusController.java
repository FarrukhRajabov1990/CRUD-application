package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankReasonStatusDTO;
import uz.soliq.entities.ClassifierBankReasonStatus;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierBankReasonStatusService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierBankReasonStatus")
public class ClassifierBankReasonStatusController {

    private final ClassifierBankReasonStatusService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierBankReasonStatus get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierBankReasonStatus>> add(
            @RequestBody ClassifierBankReasonStatusDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierBankReasonStatus>> edit(
            @RequestBody ClassifierBankReasonStatusDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
    @GetMapping("/get/all/{createdBy}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierBankReasonStatus>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(createdBy, name, version);
    }

}
