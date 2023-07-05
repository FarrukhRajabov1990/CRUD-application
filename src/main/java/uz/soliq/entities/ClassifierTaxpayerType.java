package uz.soliq.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.soliq.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSIFIER_TAXPAYER_TYPE")
public class ClassifierTaxpayerType extends BaseEntity {

    @Size(max = 255, message = "Code is too long")
    @Column(name = "CODE", nullable = false)
    private String code;
}
