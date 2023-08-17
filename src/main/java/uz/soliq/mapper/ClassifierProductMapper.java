package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierProductDTO;
import uz.soliq.entities.ClassifierProduct;

@Mapper(componentModel = "spring")
public interface ClassifierProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "productClass", source = "productClass")
    @Mapping(target = "productDivision", source = "productDivision")
    @Mapping(target = "productGroup", source = "productGroup")
    @Mapping(target = "productRank", source = "productRank")
    @Mapping(target = "productSubrank", source = "productSubrank")
    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "section", source = "section")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "parentId", source = "parentId")
    ClassifierProduct toEntity(ClassifierProductDTO dto);
}
