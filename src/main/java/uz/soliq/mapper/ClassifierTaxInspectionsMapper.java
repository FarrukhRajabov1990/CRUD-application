package uz.soliq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.soliq.dto.ClassifierTaxInspectionsDTO;
import uz.soliq.entities.ClassifierTaxInspections;

@Mapper(componentModel = "spring")
public interface ClassifierTaxInspectionsMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "ns10Code", source = "ns10Code")
    @Mapping(target = "ns11Code", source = "ns11Code")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "adres", source = "adres")
    @Mapping(target = "account", source = "account")
    @Mapping(target = "mfo", source = "mfo")
    @Mapping(target = "bank", source = "bank")
    @Mapping(target = "tin", source = "tin")
    @Mapping(target = "pindex", source = "pindex")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "fax", source = "fax")
//    @Mapping(target = "fName1", source = "fName1")
//    @Mapping(target = "name1", source = "name1")
//    @Mapping(target = "lName1", source = "lName1")
//    @Mapping(target = "fName2", source = "fName2")
//    @Mapping(target = "name2", source = "name2")
//    @Mapping(target = "lName2", source = "lName2")
//    @Mapping(target = "cName", source = "cName")
//    @Mapping(target = "cAdres", source = "cAdres")
//    @Mapping(target = "tax", source = "tax")
//    @Mapping(target = "fio1Fin", source = "fio1Fin")
//    @Mapping(target = "fio2Fin", source = "fio2Fin")
//    @Mapping(target = "telNed", source = "telNed")
//    @Mapping(target = "mfo30", source = "mfo30")
//    @Mapping(target = "mfo101", source = "mfo101")
//    @Mapping(target = "mailExps", source = "mailExps")
//    @Mapping(target = "dateConv", ignore = true)
//    @Mapping(target = "pKey", source = "pKey")
    ClassifierTaxInspections toEntity(ClassifierTaxInspectionsDTO dto);
}
