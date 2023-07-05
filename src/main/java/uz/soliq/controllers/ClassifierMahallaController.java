package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaDTO;
import uz.soliq.entities.ClassifierMahalla;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierMahallaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierMahalla")
public class ClassifierMahallaController {

    private final ClassifierMahallaService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierMahalla>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierMahalla get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierMahalla>> add(@RequestBody ClassifierMahallaDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierMahalla>> edit(@RequestBody ClassifierMahallaDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
