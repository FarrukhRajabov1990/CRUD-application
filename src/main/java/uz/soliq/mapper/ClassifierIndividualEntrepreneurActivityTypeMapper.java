package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierIndividualEntrepreneurActivityTypeDTO;
import uz.soliq.entities.ClassifierIndividualEntrepreneurActivityType;

@Mapper(componentModel = "spring")
public interface ClassifierIndividualEntrepreneurActivityTypeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "group", source = "group")
    @Mapping(target = "groupNumber", source = "groupNumber")
    @Mapping(target = "groupRu", source = "groupRu")
    @Mapping(target = "groupUzCyrl", source = "groupUzCyrl")
    @Mapping(target = "groupUzLatn", source = "groupUzLatn")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    ClassifierIndividualEntrepreneurActivityType toEntity
            (ClassifierIndividualEntrepreneurActivityTypeDTO dto);
}
