package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierOkruzDTO;
import uz.soliq.entities.ClassifierOkruz;

@Mapper(componentModel = "spring")
public interface ClassifierOkruzMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "okruzCode", source = "okruzCode")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "legalFormId", source = "legalFormId")
    ClassifierOkruz toEntity(ClassifierOkruzDTO dto);
}
