package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    @JsonProperty("content")

    public String content;
    @JsonProperty("timeStamp")

    public String timeStamp;
    @JsonProperty("last")

    public boolean last;
    @JsonProperty("timeStampStr")

    public String timeStampStr;
    @JsonProperty("podName")

    public String podName;
}
