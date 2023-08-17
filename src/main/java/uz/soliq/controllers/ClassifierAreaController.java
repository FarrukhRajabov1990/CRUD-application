package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierAreaDTO;
import uz.soliq.entities.ClassifierArea;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierAreaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierArea")
public class ClassifierAreaController {

    private final ClassifierAreaService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierArea>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierArea get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierArea>> add(@RequestBody ClassifierAreaDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierArea>> edit(@RequestBody ClassifierAreaDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{version}/{areaId}/{regionId}")
    public ResponseEntity<ResponseData<List<ClassifierArea>>> getAllBySimpleQuery(
            @PathVariable(value = "version") Long version, @PathVariable(value = "areaId") String areaId,
            @PathVariable(value = "regionId") String regionId) {
        return service.findBySimpleQuery(version, areaId, regionId);
    }
}
