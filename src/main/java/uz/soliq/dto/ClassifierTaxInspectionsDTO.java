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
public class ClassifierTaxInspectionsDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("ns10Code")
    private Integer ns10Code;

    @JsonProperty("ns11Code")
    private Integer ns11Code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("adres")
    private String adres;

    @JsonProperty("account")
    private String account;

    @JsonProperty("mfo")
    private String mfo;

    @JsonProperty("bank")
    private String bank;

    @JsonProperty("tin")
    private String tin;

    @JsonProperty("pindex")
    private String pindex;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("fax")
    private String fax;

    @JsonProperty("fName1")
    private String fName1;

    @JsonProperty("name1")
    private String name1;

    @JsonProperty("lName1")
    private String lName1;

    @JsonProperty("fName2")
    private String fName2;

    @JsonProperty("name2")
    private String name2;

    @JsonProperty("lName2")
    private String lName2;

    @JsonProperty("cName")
    private String cName;

    @JsonProperty("cAdres")
    private String cAdres;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("fio1Fin")
    private String fio1Fin;

    @JsonProperty("fio2Fin")
    private String fio2Fin;

    @JsonProperty("telNed")
    private String telNed;

    @JsonProperty("mfo30")
    private String mfo30;

    @JsonProperty("mfo101")
    private String mfo101;

    @JsonProperty("mailExps")
    private Integer mailExps;

    @JsonProperty("pKey")
    private String pKey;
}
