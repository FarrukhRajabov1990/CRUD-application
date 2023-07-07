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
public class ClassifierAreaDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("deletedBy")
    private String deletedBy;

    @JsonProperty("updatedBy")
    private String updatedBy;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("administrativeCenterId")
    private String administrativeCenterId;

    @JsonProperty("areaId")
    private String areaId;

    @JsonProperty("regionId")
    private String regionId;
}
