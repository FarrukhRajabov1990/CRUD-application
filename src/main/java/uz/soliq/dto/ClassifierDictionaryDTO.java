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
public class ClassifierDictionaryDTO {

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

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("active")
    private Short active;

    @JsonProperty("connected")
    private Short connected;

    @JsonProperty("tableName")
    private String tableName;
}
