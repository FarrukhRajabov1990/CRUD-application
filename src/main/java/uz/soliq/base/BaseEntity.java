package uz.soliq.base;

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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @Size(max = 255, message = "Id is too long")
    @Column(name = "ID", unique = true)
    protected String id;

    @JsonIgnore
    @JsonIgnoreProperties
    @CreatedDate
    @CreationTimestamp
    @Column(name = "CREATE_TS", columnDefinition = "TIMESTAMP default NOW()", nullable = false, updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime createTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "CREATED_BY")
    protected String createdBy;

    @JsonIgnore
    @JsonIgnoreProperties
    @CreatedDate
    @CreationTimestamp
    @Column(name = "DELETE_TS", columnDefinition = "TIMESTAMP default NOW()", nullable = false, updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime deleteTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "DELETED_BY")
    protected String deletedBy;

    @Size(max = 500, message = "Name is too long")
    @Column(name = "NAME")
    protected String name;

    @Size(max = 500, message = "Name in russian is too long")
    @Column(name = "NAME_RU")
    protected String nameRu;

    @Size(max = 500, message = "Cyrl name is too long")
    @Column(name = "NAME_UZ_CYRL")
    protected String nameUzCyrl;

    @Size(max = 500, message = "Latin name is too long")
    @Column(name = "NAME_UZ_LATN")
    protected String nameUzLatn;

    @JsonIgnore
    @JsonIgnoreProperties
    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "UPDATE_TS", nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    protected LocalDateTime updateTs;

    @Size(max = 255, message = "Name is too long")
    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    @Column(name = "VERSION", nullable = false)
    protected Long version;
}
