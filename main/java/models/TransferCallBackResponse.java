package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferCallBackResponse{
    @JsonProperty("nodes")
    public ArrayList<Node> nodes =new ArrayList<>();;
    @JsonProperty("hosts")
    public ArrayList<Host> hosts =new ArrayList<>();;
}






