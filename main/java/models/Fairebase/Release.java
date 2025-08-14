package models.Fairebase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {
    @JsonProperty("displayVersion")
    public String displayVersion;

    @JsonProperty("buildVersion")
    public Integer buildVersion;

    @JsonProperty("createTime")
    public String createTime;

    @JsonProperty("binaryDownloadUri")
    public String binaryDownloadUri;
}
