package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierOkruzDTO;
import uz.soliq.entities.ClassifierOkruz;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierOkruzService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierOkruz")
public class ClassifierOkruzController {
    private final ClassifierOkruzService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierOkruz>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierOkruz get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierOkruz>> add(@RequestBody ClassifierOkruzDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierOkruz>> edit(@RequestBody ClassifierOkruzDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{createdBy}/{deletedBy}/{okruzCode}")
    public ResponseEntity<ResponseData<List<ClassifierOkruz>>> getAllBySimpleQuery(
            @PathVariable(value = "createdBy") String createdBy,
            @PathVariable(value = "deletedBy") String deletedBy,
            @PathVariable(value = "okruzCode") String okruzCode) {
        return service.findBySimpleQuery(createdBy, deletedBy, okruzCode);
    }
}
