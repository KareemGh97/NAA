package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentRef {
    @JsonProperty("group")
    public String group;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("namespace")
    public String namespace;
    @JsonProperty("name")
    public String name;
    @JsonProperty("uid")
    public String uid;

}
