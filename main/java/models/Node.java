package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node{
    @JsonProperty("version")
    public String version;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("namespace")
    public String namespace;
    @JsonProperty("name")
    public String name;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("parentRefs")
    public ArrayList<ParentRef> parentRefs =new ArrayList<>();;
    @JsonProperty("resourceVersion")
    public String resourceVersion;
    @JsonProperty("createdAt")
    public String createdAt;
    @JsonProperty("info")
    public ArrayList<Info> info =new ArrayList<>();
    @JsonProperty("networkingInfo")
    public NetworkingInfo networkingInfo;
    @JsonProperty("images")
    public ArrayList<String> images =new ArrayList<>();;
    @JsonProperty("health")
    public Health health;
    @JsonProperty("group")
    public String group;
}