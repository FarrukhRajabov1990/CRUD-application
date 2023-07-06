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
@Table(name = "CLASSIFIER_DEHKAN_FARM_ACTIVITY_TYPE")
public class ClassifierDehkanFarmActivityType extends BaseEntity {

    @Column(name = "CODE", nullable = false)
    private String code;
}
