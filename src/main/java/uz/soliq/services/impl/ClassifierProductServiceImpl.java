package uz.soliq.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.soliq.common.ResponseData;
import uz.soliq.dto.ClassifierProductDTO;
import uz.soliq.entities.ClassifierProduct;
import uz.soliq.exceptions.CustomNotFoundException;
import uz.soliq.mapper.ClassifierProductMapper;
import uz.soliq.repositories.ClassifierProductRepo;
import uz.soliq.services.ClassifierProductService;
import uz.soliq.specifications.Product;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassifierProductServiceImpl implements ClassifierProductService {

    private final ClassifierProductRepo repo;
    private final ClassifierProductMapper mapper;
    private final Product querySearch;

    @Override
    public ClassifierProduct findById(String id) throws CustomNotFoundException {
        Optional<ClassifierProduct> product = repo.findById(id);
        if (product.isEmpty()) {
            throw new CustomNotFoundException("Not found!");
        }
        return product.get();
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierProduct>>> getAll() {
        return ResponseData.success200(repo.findAll());
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierProduct>> add(ClassifierProductDTO dto) {
        ClassifierProduct product = mapper.toEntity(dto);
        repo.save(product);
        return ResponseData.success201(product);
    }

    @Override
    public ResponseEntity<ResponseData<ClassifierProduct>> edit(ClassifierProductDTO dto) {
        Optional<ClassifierProduct> productOptional = repo.findById(dto.getId());
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        ClassifierProduct product = mapper.toEntity(dto);
        repo.save(product);
        return ResponseData.success201(product);
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(String id) {
        Optional<ClassifierProduct> product = repo.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Not found!");
        }
        repo.delete(product.get());
        return ResponseData.success200(true);
    }

    @Override
    public ResponseEntity<ResponseData<List<ClassifierProduct>>> findBySimpleQuery(
            String createdBy,  String deletedBy, String section) {
        return ResponseData.success200(querySearch.findAllBySimpleQuery(createdBy, deletedBy, section));
    }
}
