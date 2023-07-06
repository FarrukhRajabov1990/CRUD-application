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
@Table(name = "CLASSIFIER_INDIVIDUAL_ENTREPRENEUR_ACTIVITY_TYPE")
public class ClassifierIndividualEntrepreneurActivityType extends BaseEntity {

    @Size(max = 255, message = "Code is too long")
    @Column(name = "CODE", nullable = false)
    private String code;

    @Size(max = 255, message = "Too long")
    @Column(name = "GROUP")
    private String group;

    @Size(max = 255, message = "Too long")
    @Column(name = "GROUP_NUMBER")
    private String groupNumber;

    @Size(max = 255, message = "Too long")
    @Column(name = "GROUP_RU")
    private String groupRu;

    @Size(max = 255, message = "Too long")
    @Column(name = "GROUP_UZ_CYRL", nullable = false)
    private String groupUzCyrl;

    @Size(max = 255, message = "Too long")
    @Column(name = "GROUP_UZ_LATN")
    private String groupUzLatn;
}
