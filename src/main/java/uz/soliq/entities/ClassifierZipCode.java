package uz.soliq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSIFIER_AREA")
public class ClassifierArea implements Serializable {

    @Id
    @Size(max = 255, message = "Id is too long")
    @Column(name = "ID", unique = true)
    private String id;

    @JsonIgnore
    @JsonIgnoreProperties
    @CreatedDate
    @CreationTimestamp
    @Column(name = "CREATE_TS", columnDefinition = "TIMESTAMP default NOW()", nullable = false, updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime createTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "CREATED_BY")
    private String createdBy;

    @JsonIgnore
    @JsonIgnoreProperties
    @CreatedDate
    @CreationTimestamp
    @Column(name = "DELETE_TS", columnDefinition = "TIMESTAMP default NOW()", nullable = false, updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime deleteTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @JsonIgnore
    @JsonIgnoreProperties
    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "UPDATE_TS", nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updateTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Size(max = 255, message = "Too long")
    @Column(name = "ADMINISTRATIVE_CENTER_ID")
    private String administrativeCenterId;

    @Size(max = 255, message = "Too long")
    @Column(name = "AREA_ID", nullable = false)
    private String areaId;

    @Size(max = 255, message = "Too long")
    @Column(name = "REGION_ID", nullable = false)
    private String regionId;
}
