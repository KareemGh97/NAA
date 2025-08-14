package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Host {
    @JsonProperty("name")
    public String name;
    @JsonProperty("resourcesInfo")
    public ArrayList<ResourcesInfo> resourcesInfo =new ArrayList<>();;
    @JsonProperty("systemInfo")
    public SystemInfo systemInfo;
}
