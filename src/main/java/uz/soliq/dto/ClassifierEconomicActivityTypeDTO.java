package uz.soliq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassifierEconomicActivityTypeDTO {


    @JsonProperty("id")
    private String id;

    @JsonProperty("class_")
    private String class_;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("deletedBy")
    private String deletedBy;

    @JsonProperty("division")
    private String division;

    @JsonProperty("group")
    private String group;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nameRu")
    private String nameRu;

    @JsonProperty("nameUzCyrl")
    private String nameUzCyrl;

    @JsonProperty("nameUzLatn")
    private String nameUzLatn;

    @JsonProperty("section")
    private String section;

    @JsonProperty("subclass")
    private String subclass;

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("parentId")
    private String parentId;
}
