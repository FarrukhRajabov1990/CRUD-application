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
@Table(name = "CLASSIFIER_DICTIONARY")
public class ClassifierDictionary extends BaseEntity {

    @Column(name = "ACTIVE")
    private Short active;

    @Column(name = "CONNECTED")
    private Short connected;

    @Size(max = 255, message = "Table name is too long")
    @Column(name = "TABLE_NAME")
    private String tableName;
}
