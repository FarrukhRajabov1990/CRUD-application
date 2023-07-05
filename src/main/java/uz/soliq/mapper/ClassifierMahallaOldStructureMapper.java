package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierMahallaOldStructureDTO;
import uz.soliq.entities.ClassifierMahallaOldStructure;

@Mapper(componentModel = "spring")
public interface ClassifierMahallaOldStructureMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "districtSectorId", source = "districtSectorId")
    @Mapping(target = "soato", source = "soato")
    @Mapping(target = "regionSectorId", source = "regionSectorId")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "active", source = "active")
    ClassifierMahallaOldStructure toEntity(ClassifierMahallaOldStructureDTO dto);
}
