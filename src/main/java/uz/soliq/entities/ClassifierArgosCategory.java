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
@Table(name = "CLASSIFIER_ARGOS_CATEGORY")
public class ClassifierArgosCategory extends BaseEntity {

    @Size(max = 255, message = "Too long")
    @Column(name = "CODE", nullable = false)
    private String code;

    @Size(max = 1, message = "Only one character allowed")
    @Column(name = "LETTER")
    private Character letter;
}
