package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierEconomicActivityTypeDTO;
import uz.soliq.entities.ClassifierEconomicActivityType;

@Mapper(componentModel = "spring")
public interface ClassifierEconomicActivityTypeMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "class_", source = "class_")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "division", source = "division")
    @Mapping(target = "group", source = "group")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "section", source = "section")
    @Mapping(target = "subclass", source = "subclass")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "parentId", source = "parentId")
    ClassifierEconomicActivityType toEntity (ClassifierEconomicActivityTypeDTO dto);
}
