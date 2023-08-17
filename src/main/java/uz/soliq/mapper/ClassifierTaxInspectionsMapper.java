package uz.soliq.mapper;

import uz.soliq.dto.ClassifierTaxInspectionsDTO;
import uz.soliq.entities.ClassifierTaxInspections;

public interface ClassifierTaxInspectionsMapper {

    default ClassifierTaxInspections toEntity(ClassifierTaxInspectionsDTO dto){

        ClassifierTaxInspections inspections = new ClassifierTaxInspections();
        inspections.setId(dto.getId());
        inspections.setNs10Code(dto.getNs10Code());
        inspections.setNs11Code(dto.getNs11Code());
        inspections.setName(dto.getName());
        inspections.setAdres(dto.getAdres());
        inspections.setAccount(dto.getAccount());
        inspections.setMfo(dto.getMfo());
        inspections.setBank(dto.getBank());
        inspections.setTin(dto.getTin());
        inspections.setPindex(dto.getPindex());
        inspections.setPhone(dto.getPhone());
        inspections.setFax(dto.getFax());
        inspections.setFName1(dto.getFName1());
        inspections.setName1(dto.getName1());
        inspections.setLName1(dto.getLName1());
        inspections.setFName2(dto.getFName2());
        inspections.setName2(dto.getName2());
        inspections.setLName2(dto.getLName2());
        inspections.setCName(dto.getCName());
        inspections.setCAdres(dto.getCAdres());
        inspections.setTax(dto.getTax());
        inspections.setFio1Fin(dto.getFio1Fin());
        inspections.setFio2Fin(dto.getFio2Fin());
        inspections.setTelNed(dto.getTelNed());
        inspections.setMfo30(dto.getMfo30());
        inspections.setMfo101(dto.getMfo101());
        inspections.setMailExps(dto.getMailExps());
        inspections.setPKey(dto.getPKey());

        return inspections;
    }
}
