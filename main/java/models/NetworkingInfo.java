package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkingInfo {
    @JsonProperty("labels")
    public Labels labels;
    @JsonProperty("targetLabels")
    public TargetLabels targetLabels;
    @JsonProperty("targetRefs")
    public ArrayList<TargetRef> targetRefs =new ArrayList<>();;
}
