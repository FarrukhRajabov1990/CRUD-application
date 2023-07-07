package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierBankDTO;
import uz.soliq.entities.ClassifierBank;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierBankService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierBank")
public class ClassifierBankController {

    private final ClassifierBankService service;

    
    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierBank>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierBank get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierBank>> add(@RequestBody ClassifierBankDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierBank>> edit(@RequestBody ClassifierBankDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
