package uz.soliq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSIFIER_TAX_INSPECTIONS")
public class ClassifierTaxInspections {

    @Id
    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "NS10_CODE", nullable = false)
    private Integer ns10Code;

    @Column(name = "NS11_CODE", nullable = false)
    private Integer ns11Code;

    @Size(max = 250, message = "Name is too long")
    @Column(name = "NAME")
    private String name;

    @Size(max = 250, message = "Too long")
    @Column(name = "ADRES")
    private String adres;

    @Size(max = 20, message = "Too long")
    @Column(name = "ACCOUNT")
    private String account;

    @Size(max = 5, message = "Too long")
    @Column(name = "MFO")
    private String mfo;

    @Size(max = 250, message = "Too long")
    @Column(name = "BANK")
    private String bank;

    @Size(max = 9, message = "Too long")
    @Column(name = "TIN", nullable = false)
    private String tin;

    @Size(max = 6, message = "Too long")
    @Column(name = "PINDEX")
    private String pindex;

    @Size(max = 64, message = "Too long")
    @Column(name = "PHONE")
    private String phone;

    @Size(max = 64, message = "Too long")
    @Column(name = "FAX")
    private String fax;

    @Size(max = 20, message = "Too long")
    @Column(name = "FNAME1")
    private String fName1;

    @Size(max = 20, message = "Too long")
    @Column(name = "NAME1")
    private String name1;

    @Size(max = 20, message = "Too long")
    @Column(name = "LNAME1")
    private String lName1;

    @Size(max = 20, message = "Too long")
    @Column(name = "FNAME2")
    private String fName2;

    @Size(max = 20, message = "Too long")
    @Column(name = "NAME2")
    private String name2;

    @Size(max = 20, message = "Too long")
    @Column(name = "LNAME2")
    private String lName2;

    @Size(max = 250, message = "Too long")
    @Column(name = "CNAME")
    private String cName;

    @Size(max = 250, message = "Too long")
    @Column(name = "CADRES")
    private String cAdres;

    @Size(max = 250, message = "Too long")
    @Column(name = "TAX")
    private String tax;

    @Size(max = 100, message = "Too long")
    @Column(name = "FIO1_FIN")
    private String fio1Fin;

    @Size(max = 100, message = "Too long")
    @Column(name = "FIO2_FIN")
    private String fio2Fin;

    @Size(max = 64, message = "Too long")
    @Column(name = "TEL_NED")
    private String telNed;

    @Size(max = 5, message = "Too long")
    @Column(name = "MFO30")
    private String mfo30;

    @Size(max = 5, message = "Too long")
    @Column(name = "MFO101")
    private String mfo101;

    @Column(name = "MAILEXPS")
    private Integer mailExps;

    @JsonIgnore
    @JsonIgnoreProperties
    @CreatedDate
    @CreationTimestamp
    @Column(name = "DATE_CONV", columnDefinition = "TIMESTAMP default NOW()", nullable = false, updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime dateConv;

    @Size(max = 32, message = "Too long")
    @Column(name = "PKEY")
    private String pKey;
}
