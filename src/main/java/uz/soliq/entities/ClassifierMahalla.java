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
@Table(name = "CLASSIFIER_MAHALLA")
public class ClassifierMahalla extends BaseEntity {

    @Column(name = "CODE", nullable = false)
    private Long code;

    @Column(name = "DISTRICT_ID")
    private Integer districtId;

    @Column(name = "SECTOR_ID")
    private Integer sectorId;

    @Column(name = "ACTIVE")
    private Integer active;

    @Column(name = "REGION_ID")
    private Integer regionId;
}
