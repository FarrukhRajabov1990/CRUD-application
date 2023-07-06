package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierSoatoDTO;
import uz.soliq.entities.ClassifierSoato;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierSoatoMapper;
import uz.soliq.repositories.ClassifierSoatoRepo;
import uz.soliq.services.ClassifierSoatoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierSoatoServiceImpl implements ClassifierSoatoService {

    private final ClassifierSoatoRepo repo;
    private final ClassifierSoatoMapper mapper;

    @Override
    public ClassifierSoato findById(String id) throws CustomNotFoundException {
        Optional<ClassifierSoato> soatoOptional = repo.findById(id);
        if (soatoOptional.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return soatoOptional.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierSoato>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSoato>> add(ClassifierSoatoDTO dto) {
        ClassifierSoato soato = mapper.toEntity(dto);
        repo.save(soato);
        return ResponseData.success201(soato);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierSoato>> edit(ClassifierSoatoDTO dto) {
        Optional<ClassifierSoato> soatoOptional = repo.findById(dto.getId());
        if (soatoOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierSoato soato = mapper.toEntity(dto);
        repo.save(soato);
        return ResponseData.success201(soato);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierSoato> soatoOptional = repo.findById(id);
        if (soatoOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(soatoOptional.get());
        return ResponseData.success200(true);
    }
}
