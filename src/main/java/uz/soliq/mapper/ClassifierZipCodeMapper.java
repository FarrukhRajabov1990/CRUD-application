package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierAreaDTO;
import uz.soliq.entities.ClassifierArea;

@Mapper(componentModel = "spring")
public interface ClassifierAreaMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "administrativeCenterId", source = "administrativeCenterId")
    @Mapping(target = "areaId", source = "areaId")
    @Mapping(target = "regionId", source = "regionId")
    ClassifierArea toEntity(ClassifierAreaDTO dto);
}
