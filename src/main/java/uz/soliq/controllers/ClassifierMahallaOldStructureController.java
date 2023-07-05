package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierMahallaOldStructureDTO;
import uz.soliq.entities.ClassifierMahallaOldStructure;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierMahallaOldStructureService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierMahallaOldStructure")
public class ClassifierMahallaOldStructureController {

    private final ClassifierMahallaOldStructureService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierMahallaOldStructure>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierMahallaOldStructure get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> add(@RequestBody ClassifierMahallaOldStructureDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierMahallaOldStructure>> edit(@RequestBody ClassifierMahallaOldStructureDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }
}
