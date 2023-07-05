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
@Table(name = "CLASSIFIER_SUSPENSION_REASON")
public class ClassifierSuspensionReason extends BaseEntity {

    @Column(name = "CODE", nullable = false)
    private Integer code;

    @Column(name = "ACTIVE")
    private Integer active;
}
