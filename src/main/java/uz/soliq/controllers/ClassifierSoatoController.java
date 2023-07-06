package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSoatoDTO;
import uz.soliq.entities.ClassifierSoato;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierSoatoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierSoato")
public class ClassifierSoatoController {

    private final ClassifierSoatoService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierSoato>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierSoato get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierSoato>> add(@RequestBody ClassifierSoatoDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierSoato>> edit(@RequestBody ClassifierSoatoDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
