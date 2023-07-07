package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierArgosTerritorialLevelDTO;
import uz.soliq.entities.ClassifierArgosTerritorialLevel;

@Mapper(componentModel = "spring")
public interface ClassifierArgosTerritorialLevelMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    ClassifierArgosTerritorialLevel toEntity(ClassifierArgosTerritorialLevelDTO dto);
}
