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
@Table(name = "CLASSIFIER_ECONOMIC_ACTIVITY_TYPE")
public class ClassifierEconomicActivityType extends BaseEntity {

    @Size(max = 255, message = "Class is too long")
    @Column(name = "CLASS_", nullable = false)
    private String class_;

    @Size(max = 255, message = "Division is too long")
    @Column(name = "DIVISION", nullable = false)
    private String division;

    @Size(max = 255, message = "Group is too long")
    @Column(name = "GROUP", nullable = false)
    private String group;

    @Size(max = 255, message = "Section is too long")
    @Column(name = "SECTION", nullable = false)
    private String section;

    @Size(max = 255, message = "Subclass is too long")
    @Column(name = "SUBCLASS", nullable = false)
    private String subclass;

    @Size(max = 255, message = "Parent_id is too long")
    @Column(name = "PARENT_ID")
    private String parentId;
}
