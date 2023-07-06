package uz.soliq.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.soliq.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSIFIER_BANK")
public class ClassifierBank extends BaseEntity {

    @Size(max = 255, message = "Too long, shouldn't be more than 255 characters")
    @Column(name = "ADDRESS")
    private String address;

    @Size(max = 255, message = "Too long, shouldn't be more than 255 characters")
    @Column(name = "AREA_CODE")
    private String areaCode;

    @Size(max = 255, message = "Too long, shouldn't be more than 255 characters")
    @Column(name = "AREA_NAME")
    private String areaName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FINISH_DATE")
    private LocalDateTime finishDate;

    @Size(max = 255, message = "Too long")
    @Column(name = "FIO")
    private String fio;

    @Size(max = 255, message = "Too long")
    @Column(name = "INN")
    private String inn;

    @Size(max = 255, message = "Too long")
    @Column(name = "MFO")
    private String mfo;

    @Size(max = 255, message = "Too long")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Size(max = 255, message = "Too long")
    @Column(name = "ZIP_CODE")
    private String zipCode;
}
