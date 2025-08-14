package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemInfo {
    @JsonProperty("machineID")
    public String machineID;
    @JsonProperty("systemUUID")
    public String systemUUID;
    @JsonProperty("bootID")
    public String bootID;
    @JsonProperty("kernelVersion")
    public String kernelVersion;
    @JsonProperty("osImage")
    public String osImage;
    @JsonProperty("containerRuntimeVersion")
    public String containerRuntimeVersion;
    @JsonProperty("kubeletVersion")
    public String kubeletVersion;
    @JsonProperty("kubeProxyVersion")
    public String kubeProxyVersion;
    @JsonProperty("operatingSystem")
    public String operatingSystem;
    @JsonProperty("architecture")
    public String architecture;
}
