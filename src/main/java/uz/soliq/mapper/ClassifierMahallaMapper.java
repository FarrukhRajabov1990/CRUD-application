package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierMahallaDTO;
import uz.soliq.entities.ClassifierMahalla;

@Mapper(componentModel = "spring")
public interface ClassifierMahallaMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "districtId", source = "districtId")
    @Mapping(target = "sectorId", source = "sectorId")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "regionId", source = "regionId")
    ClassifierMahalla toEntity(ClassifierMahallaDTO dto);
}
