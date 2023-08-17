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
@Table(name = "CLASSIFIER_CRAFTSMAN_ACTIVITY_TYPE")
public class ClassifierCraftsmanActivityType extends BaseEntity {

    @Size(max = 255, message = "Too long")
    @Column(name = "CODE", nullable = false)
    private String code;
}
