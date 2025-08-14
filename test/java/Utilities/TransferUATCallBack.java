package Utilities;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import models.AlphaTransferServiceResponse;
import models.TransferCallBackResponse;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class TransferUATCallBack {
    public static TransferCallBackResponse transferCallBackResponse;
    public static AlphaTransferServiceResponse alphaTransferServiceResponse;

    public static String podId = "";

    public static void getPodId() {
        RestAssured.config = RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());

        RestAssured.baseURI = "https://argocd.apps.dev-nonpci-shared.npnbank.local";
        Response response = RestAssured.given().header("Content-Type", "application/json").get("/api/v1/applications/uat-nonpci-appdb-alpha-transfers-service/resource-tree?appNamespace=");
        String jsonResponse = response.getBody().asString();
        transferCallBackResponse = response.getBody().as(TransferCallBackResponse.class);
        System.out.println(jsonResponse);
        Assert.assertNotNull(transferCallBackResponse);
        for (int i = 0; i < transferCallBackResponse.getNodes().size(); i++) {
            if (transferCallBackResponse.getNodes().get(i).getKind().equalsIgnoreCase("pod")) {
                if (transferCallBackResponse.getNodes().get(i).getHealth().getStatus().equalsIgnoreCase("Healthy")) {
                    podId = transferCallBackResponse.getNodes().get(i).getName();
                }


            }
        }


        System.out.println(podId);
        handleTransferServiceResponse(podId);
    }

    public static void handleTransferServiceResponse(String podId) {
        RestAssured.config = RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());

        RestAssured.baseURI = "https://argocd.apps.dev-nonpci-shared.npnbank.local";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("appNamespace", "argocd")
                .queryParam("container", "alpha-transfers-service")
                .queryParam("namespace", "alpha")
                .queryParam("follow", "false")
                .queryParam("podName", podId)
                .queryParam("tailLines", "100")
                .queryParam("sinceSeconds", "0")
                .get("/api/v1/applications/uat-nonpci-appdb-alpha-transfers-service/logs");
        String jsonResponse = response.getBody().asString();
        alphaTransferServiceResponse = response.getBody().as(AlphaTransferServiceResponse.class);
        Assert.assertNotNull(alphaTransferServiceResponse);
        System.out.println(podId);
    }

    public static void PostAccountVerification() {
        try {
            RestAssured.baseURI = "https://alpha-transfers-service.apps.uat-nonpci-appdb.npnbank.local/external";
            //POST request
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("x-correlation-id", "");
            headers.put("Content-Type", "application/json");
            headers.put("clientId", "MPclient");  // Example of adding an authorization header
            headers.put("clientSecret", "a9anZtafY8hqPLEgGfYt");       // Additional custom header
            headers.put("Authorization", "Bearer gZDkRVs8mYV6ygXWFBsZ");
            // Define JSON body payload
            String requestBody = "{\n" +
                    "    \"RequestId\": \"value1\",\n" +
                    "    \"Source\": \"Saudi-Payment\",\n" +
                    "    \"key3\": \"value3\"\n" +
                    "}";

            // Make the POST request with query parameters, headers, and JSON body
            Response response = RestAssured.given()
                    .headers(headers)         // Add multiple headers from the map
                    .body(requestBody)        // Add JSON body
                    .post("/api/v1/applications/uat-nonpci-appdb-alpha-transfers-service/resource-tree");

            // Convert response to string and print it
            String jsonResponse = response.getBody().asString();
            System.out.println(jsonResponse);
        } finally {

        }

    }


    public static void main(String[] args) {
    TransferUATCallBack.getPodId();
}
}
