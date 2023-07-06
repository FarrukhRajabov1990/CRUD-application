package uz.soliq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassifierBankDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("address")
    private String address;

    @JsonProperty("areaCode")
    private String areaCode;

    @JsonProperty("areaName")
    private String areaName;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("deletedBy")
    private String deletedBy;

    @JsonProperty("finishDate")
    private LocalDateTime finishDate;

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("inn")
    private String inn;

    @JsonProperty("mfo")
    private String mfo;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nameRu")
    private String nameRu;

    @JsonProperty("nameUzCyrl")
    private String nameUzCyrl;

    @JsonProperty("nameUzLatn")
    private String nameUzLatn;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("zipCode")
    private String zipCode;
}
