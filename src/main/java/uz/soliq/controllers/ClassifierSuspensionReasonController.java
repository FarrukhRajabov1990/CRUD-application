package uz.soliq.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSuspensionReasonDTO;
import uz.soliq.entities.ClassifierSuspensionReason;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.services.ClassifierSuspensionReasonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classifierSuspensionReason")
public class ClassifierSuspensionReasonController {

    private final ClassifierSuspensionReasonService service;

    @GetMapping("/get/all")
    public ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ClassifierSuspensionReason get(@PathVariable(value = "id") String id) throws CustomNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData<ClassifierSuspensionReason>> add(@RequestBody ClassifierSuspensionReasonDTO dto) {
        return service.add(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseData<ClassifierSuspensionReason>> edit(@RequestBody ClassifierSuspensionReasonDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") String id) {
        return service.delete(id);
    }

    @GetMapping("/get/all/{code}/{name}/{version}")
    public ResponseEntity<ResponseData<List<ClassifierSuspensionReason>>> getAllBySimpleQuery(
            @PathVariable(value = "code") Integer code, @PathVariable(value = "name") String name,
            @PathVariable(value = "version") Long version) {
        return service.findBySimpleQuery(code, name, version);
    }
}
