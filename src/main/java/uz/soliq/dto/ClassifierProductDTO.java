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
public class ClassifierProductDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("deletedBy")
    private String deletedBy;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nameRu")
    private String nameRu;

    @JsonProperty("nameUzCyrl")
    private String nameUzCyrl;

    @JsonProperty("nameUzLatn")
    private String nameUzLatn;

    @JsonProperty("productClass")
    private String productClass;

    @JsonProperty("productDivision")
    private String productDivision;

    @JsonProperty("productGroup")
    private String productGroup;

    @JsonProperty("productRank")
    private String productRank;

    @JsonProperty("productSubrank")
    private String productSubrank;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("section")
    private String section;

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("parentId")
    private Long parentId;
}
