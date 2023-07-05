package uz.soliq.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.soliq.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSIFIER_MAHALLA_OLD_STRUCTURE")
public class ClassifierMahallaOldStructure extends BaseEntity {

    @Column(name = "CODE", nullable = false)
    private Integer code;

    @Column(name = "DISTRICT_SECTOR_ID")
    private Integer districtSectorId;

    @Column(name = "SOATO")
    private Integer soato;

    @Column(name = "REGION_SECTOR_ID")
    private Integer regionSectorId;

    @Column(name = "ACTIVE")
    private Integer active;
}
