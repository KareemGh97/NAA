package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Labels{
    @JsonProperty("app")
    public String app;
    @JsonProperty("istio.io/rev")
    public String istio_io_rev;
    @JsonProperty("maistra-version")
    public String maistra_version;
    @JsonProperty("pod-template-hash")
    public String pod_template_hash;
    @JsonProperty("security.istio.io/tlsMode")
    public String io_tlsMode;
    @JsonProperty("service.istio.io/canonical-name")
    public String canonical_name;
    @JsonProperty("service.istio.io/canonical-revision")
    public String canonical_revision;
    @JsonProperty("version")
    public String version;
}
