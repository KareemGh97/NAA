package Utilities.APIs;

import TestBases.TestBase;
import Utilities.Reader.DataReaderManager;
import Utilities.commonClasses.AppConstants;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.security.SecureRandom;

import java.net.URLDecoder;

import java.util.HashMap;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CommonAPIs {

    private static final String APP_CENTER_URL = "https://appcenter.ms/orgs/Alrajhi-Bank/apps/Croatia-iOS-SIT/distribute/releases/155";
    private static final String APP_CENTER_API_TOKEN = "1956c7b78f67703d441a92edee30584d32b3d2a3";
    public static String SITBASEURL=DataReaderManager.getValue("APIsData","SITBaseURL");
    public static String UATBASEURL=DataReaderManager.getValue("APIsData","UATBaseURL");
    public static String CUSTOMERVERSION2ENDPOINT=DataReaderManager.getValue("APIsData","CustomerVersion2EndPoint");
    public static String ACCESSTOKENENDPOINT=DataReaderManager.getValue("APIsData","AccessTokenEndpoint");
    public static String SEARCHUSERBYNATIONALID=DataReaderManager.getValue("APIsData","SearchUserByNationalIdEndPoint");
    public static String BASEURL=DataReaderManager.getValue("APIsData","BaserURL");

    // created By rahaf eid

    public static String accessToken(){

        baseURI=BASEURL;
        return given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType("application/x-www-form-urlencoded")
                .cookie("AMWEBJCT!%2Fmga!JSESSIONID=0000Qsojm4Xggtmi3Oki7oGA1Ne:492c1ad8-405d-4f9f-8c57-cf9819a13a78; IV_JCT=%2Fmga; JSESSIONID=0000GU8j6Wa3VP6C1XMFugtsex4:492c1ad8-405d-4f9f-8c57-cf9819a13a78")
                .cookie("AMWEBJCT!%2Fmga!JSESSIONID=0000GU8j6Wa3VP6C1XMFugtsex4:492c1ad8-405d-4f9f-8c57-cf9819a13a78:9da96c56-3c5d-4c4f-9e10-c143f05402f0; IV_JCT=%2Fmga; JSESSIONID=0000Mrpxi0Ch3v15FbtZtQsndHd:9da96c56-3c5d-4c4f-9e10-c143f05402f0; PD-S-SESSION-ID=1_2_1_xWS-hP6zTVO0ID7mUopOZ0MuaE8xksC0DMjF2a16v3aFQi39")
                .formParam("client_id","myclient")
                .formParam("client_secret","NfsRsWmJB4BSSqLKJ9DM")
                .formParam("scope","openid")
                .formParam("grant_type","client_credentials")
                .post(ACCESSTOKENENDPOINT)
                .then().log().all().statusCode(200)
                .extract()
                .path("access_token");
    }
    public static String getBaseUrl(String keyWord){
        switch (System.getenv("environment")){
            case "Sit"->{return DataReaderManager.getValue("SitBaseUrls",keyWord);}
            case "Uat"->{return DataReaderManager.getValue("UatBaseUrls",keyWord);}
            default -> {
                return "InValid Platform";
            }
        }
    }

    public void topUpBalance(String Account,String balance) {

        String x_idempotency_key=randomString();
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> Initiation = getStringObjectMap(Account, balance,x_idempotency_key);
        data.put("Initiation", Initiation);
        requestBody.put("Data",data);
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI="https://alpha-temenos-banking-adapter.apps.uat-nonpci-appdb.npnbank.local/";

        } else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI="https://alpha-temenos-banking-adapter.apps.sit-nonpci-appdb.npnbank.local/";
        }
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .header("x-idempotency-key",x_idempotency_key)
                .accept("*/*")
                .body(requestBody)
                .post("protected/v1/domestic-payments?type=INCOMING")
                .then().log().all()
                .statusCode(200);
    }
    public static void findUserCic (String CivilianID) {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("CivilianID",CivilianID);
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI="https://alpha-crm-adapter.apps.uat-nonpci-appdb.npnbank.local";

        } else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI="https://alpha-crm-adapter.apps.sit-nonpci-appdb.npnbank.local";
        }
        Response response = given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .header("x-correlation-id",UUID.randomUUID())
                .header("Content-Type","application/json")
                .accept("application/json")
                .body(requestBody)
                .post(" /v1/customers/search");
        AppConstants.cic.set(  response.jsonPath().getString("Customers[0].CustomerId"));
    }

    private static Map<String, Object> getStringObjectMap(String Account, String balance,String x) {
        Map<String, Object> Initiation = new HashMap<>();
        Map<String, Object> CreditorAccount = new HashMap<>();
        Map<String, Object> InstructedAmount = new HashMap<>();
        Map<String, Object> SupplementaryData = new HashMap<>();


        CreditorAccount.put("Identification", Account);
        InstructedAmount.put("Amount", balance);
        InstructedAmount.put("Currency","SAR");
        SupplementaryData.put("OrderingCustomer","999999");
        Initiation.put("CreditorAccount", CreditorAccount);
        Initiation.put("InstructedAmount", InstructedAmount);
        Initiation.put("SupplementaryData", SupplementaryData);
        Initiation.put("InstructionIdentification",x);
        Initiation.put("LocalInstrument", "IPS");
        return Initiation;
    }

    public String randomString() {
         String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
         int STRING_LENGTH = 25;
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {
            int index = ThreadLocalRandom.current().nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public void activateUser(String  CIC){
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI=DataReaderManager.getValue("APIsData","UATBaseURL");

        }
        else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI=DataReaderManager.getValue("APIsData","SITBaseURL");
        }
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("x-correlation-id", "test")
                .header("Authorization", "Bearer " + accessToken())
                .pathParam("CID", CIC)
                .pathParam("manage","manage")
                .body("{\"ActionId\": 1 }")
                .when()
                .patch(DataReaderManager.getValue("APIsData","CustomerVersion2EndPoint")+"{CID}/{manage}")
                .then().log().all()
                .statusCode(200);

    }
    public void activateUserInCRM(String CIC){
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI=DataReaderManager.getValue("APIsData","UATCRMBaseURL");

        }
        else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI=DataReaderManager.getValue("APIsData","SITCRMBaseURL");
        }
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("x-correlation-id", "test")
                .header("UserId", CIC)
                .body("{\"ActionId\": 2, \"UserStatusId\": \"1\" }")
                .when()
                .patch(DataReaderManager.getValue("APIsData","CRMActivate"))
                .then().log().all()
                .statusCode(200);

    }

    public void removeBlockCode(String  CIC){
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI="https://alpha-temenos-banking-adapter.apps.uat-nonpci-appdb.npnbank.local";

        }
        else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI="https://alpha-temenos-banking-adapter.apps.sit-nonpci-appdb.npnbank.local";
        }
        String requestBody = """
            {
              "BlockCode": "",
              "RestrictionId": "",
              "Duration": 0,
              "PartnerId": "11111"
            }
        """;
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("x-correlation-id", "test")
                .header("Authorization", "Bearer " + accessToken())
                .header("userId", AppConstants.cic.get())

                .body("            {\n" +
                        "              \"BlockCode\": \"\",\n" +
                        "              \"RestrictionId\": \"\",\n" +
                        "              \"Duration\": 0,\n" +
                        "              \"PartnerId\": \"11111\"\n" +
                        "            }")
                .when()
                .put("/internal/v1/customer/block-codes-entry")
                .then().log().all()
                .statusCode(200);
    }
    public void updateNafathCount(String  CIC){
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI="https://alpha-authentication-service.apps.uat-nonpci-appdb.npnbank.local";

        }
        else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI="https://alpha-authentication-service.apps.sit-nonpci-appdb.npnbank.local";
        }
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("x-correlation-id", "dsadsadsadas")
                .header("Authorization", "Bearer " + accessToken())
                .pathParam("CID", CIC)
                .when()
                .patch("/v2/customers/"+"{CID}/nafath/usage-count")
                .then().log().all()
                .statusCode(200);
    }
    public void removeRestriction(String  CIC){
        Map<String, Object> requestBody = new HashMap<>();
        if( TestBase.environment.equalsIgnoreCase("uat"))
        {
            baseURI="https://alpha-crm-adapter.apps.uat-nonpci-appdb.npnbank.local";

        } else if (TestBase.environment.equalsIgnoreCase("sit")) {
            baseURI="https://alpha-crm-adapter.apps.sit-nonpci-appdb.npnbank.local";
        }
        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("x-correlation-id", "dsadsadsadas")
                .header("UserId", CIC)
                .body("{    \n" +
                        "     \"ActionId\": 2,   \n" +
                        "     \"UserStatusId\": \"14\"\n" +
                        "}")
                .when()
                .patch("/internal/v1/customers/status")
                .then().log().all()
                .statusCode(200);
    }
    public  String getIsvaUserId(String nationalId){
        baseURI=BASEURL;
        return given()
                .log()
                .all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON.toString())
                .accept("*/*")
                .header("Authorization", "Bearer " + accessToken())
                .queryParam("filter", URLDecoder.decode("userName+eq+")+nationalId)
                .when()
                .get("/scim/Users")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("Resources[0].id");
    }

    public String resetPasscode(String nationalId) {
        String isva = getIsvaUserId(nationalId);
        String baseURI = BASEURL + "/scim/Users/" + isva;

        // Generate a random passcode
        String newPasscode = generateRandomNumericPasscode();
        String requestBody = "{"
                + "\"schemas\":[\"urn:ietf:params:scim:api:messages:2.0:PatchOp\"],"
                + "\"Operations\":["
                + "{"
                + "\"op\":\"replace\","
                + "\"path\":\"urn:ietf:params:scim:schemas:extension:isam:1.0:User:password\","
                + "\"value\":\"" + newPasscode + "\""
                + "}"
                + "]"
                + "}";

        given()
                .log().all()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .accept("*/*")
                .header("Authorization", "Bearer " + accessToken())
                .body(requestBody)
                .when()
                .patch(baseURI)
                .then()
                .statusCode(200);
        return newPasscode; // Return the newly generated passcode
    }

    private String generateRandomNumericPasscode() {
        SecureRandom random = new SecureRandom();
        StringBuilder passcode = new StringBuilder();

        for (int i = 0; i < 6; i++) { // Generate a 6-digit passcode
            passcode.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return passcode.toString();
    }
}
