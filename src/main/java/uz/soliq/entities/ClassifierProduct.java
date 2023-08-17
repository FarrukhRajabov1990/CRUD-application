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
@Table(name = "CLASSIFIER_PRODUCT")
public class ClassifierProduct extends BaseEntity {

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_CLASS", nullable = false)
    private String productClass;

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_DIVISION", nullable = false)
    private String productDivision;

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_GROUP", nullable = false)
    private String productGroup;

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_RANK", nullable = false)
    private String productRank;

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_SUBRANK", nullable = false)
    private String productSubrank;

    @Size(max = 255, message = "Too long")
    @Column(name = "PRODUCT_TYPE", nullable = false)
    private String productType;

    @Size(max = 255, message = "Too long")
    @Column(name = "SECTION")
    private String section;

    @Size(max = 255, message = "Too long")
    @Column(name = "PARENT_ID")
    private String parentId;
}
