package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierBankDTO;
import uz.soliq.entities.ClassifierBank;

@Mapper(componentModel = "spring")
public interface ClassifierBankMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "areaCode", source = "areaCode")
    @Mapping(target = "areaName", source = "areaName")
    @Mapping(target = "createTs", ignore = true)
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "deleteTs", ignore = true)
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "finishDate", source = "finishDate")
    @Mapping(target = "fio", source = "fio")
    @Mapping(target = "inn", source = "inn")
    @Mapping(target = "mfo", source = "mfo")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "nameRu", source = "nameRu")
    @Mapping(target = "nameUzCyrl", source = "nameUzCyrl")
    @Mapping(target = "nameUzLatn", source = "nameUzLatn")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "updateTs", ignore = true)
    @Mapping(target = "updatedBy", source = "updatedBy")
    @Mapping(target = "version", source = "version")
    @Mapping(target = "zipCode", source = "zipCode")
    ClassifierBank toEntity(ClassifierBankDTO dto);
}
