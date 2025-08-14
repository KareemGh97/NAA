package Utilities.Xray;// Sample Java code to import Cucumber test results into Xray


import TestBases.TestBase;
import Utilities.Reader.DataReaderManager;
import Utilities.commonClasses.AppConstants;
import com.fasterxml.jackson.databind.node.ArrayNode;
import kong.unirest.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.JsonNode;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class XrayIntegration {
    static String executionID="";
    public static String executionKey="";
    static String testPlanKey = "XRAY-2190";  // Replace with your actual Test Plan key
    public static String clientId= DataReaderManager.getValue("clientCredentials","client_id");
    public static String clientSecret= DataReaderManager.getValue("clientCredentials","client_secret");

    public static String GenerateToken() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        String apiUrl = "https://xray.cloud.getxray.app/api/v2/authenticate";
        try {
            String jsonBody="{\n    \"client_id\": \"" + clientId  + "\",\n   \"client_secret\": \"" + clientSecret + "\"\n}";
            System.out.println(jsonBody);
            // Construct the HTTP request
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(apiUrl);
            // Set headers
            request.addHeader("Content-Type", "application/json");
            //request.addHeader("Authorization", "Bearer "+GenerateToken());

            // Set the JSON body
            StringEntity requestBody = new StringEntity(jsonBody);
            request.setEntity(requestBody);

            // Send the HTTP POST request
            HttpResponse response = httpClient.execute(request);

            // Handle the response
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity).replaceAll("\"", "");
            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            return  responseBody;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String FetchExecutionResults() {
        String apiUrl = "https://xray.cloud.getxray.app/api/internal/testruns?testExecIssueId="+executionID+"";

        try {

            //String jsonBody = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);
            // String jsonBody="{\"operationName\":\"issueViewInteractiveQuery\",\"query\":\"\\nquery issueViewInteractiveQuery($issueKey: String!, $projectKey: String)  {\\n        \\n    jira {\\n        ecosystemFirstSeenOnIssueView\\n        hasAdministerPermission: hasGlobalPermission(key: ADMINISTER)\\n            hasUserPickerPermission: hasGlobalPermission(key: USER_PICKER)\\n    }\\n\\n        mediaContext(issueKey: $issueKey) {\\n    userToken {\\n      token\\n      id\\n      issueId\\n      tokenDurationInMins\\n    }\\n    uploadToken {\\n      __typename\\n      ... on MediaUploadToken {\\n        endpointUrl\\n        token\\n        targetCollection\\n        tokenDurationInMins\\n        clientId\\n      }\\n      ... on FailedMediaUploadToken {\\n        error\\n      }\\n    }\\n    readToken(maxTokenLength: 65536) {\\n      clientId\\n      endpointUrl\\n      tokensWithFiles {\\n        files {\\n          issueId\\n          attachmentId\\n          attachmentMediaApiId\\n        }\\n        token\\n      }\\n      tokenLifespanInSeconds\\n    }\\n  }\\n        \\n    viewIssue(issueKey: $issueKey) {\\n        isArchived\\n        canCreateSubTask\\n        \\n        comments (first: 0, maxResults: 5, orderBy: \\\"-created\\\") {\\n            nodes {\\n                id\\n                author {\\n                    accountId\\n                    displayName\\n                    avatarUrl\\n                }\\n                updateAuthor {\\n                    accountId\\n                    displayName\\n                    avatarUrl\\n                }\\n                 jiraCommentVisibility {\\n    __typename\\n    ...on JiraRoleVisibility {\\n      name\\n    }\\n    ...on JiraGroupVisibility {\\n      group {\\n        groupId\\n        name\\n      }\\n    }\\n  }\\n                created\\n                updated\\n                jsdPublic\\n                bodyAdf\\n                jsdAuthorCanSeeRequest\\n                \\n                \\n            }\\n            totalCount\\n            startIndex\\n        }\\n    \\n        \\n        \\n    ecosystem {\\n      \\n      activityPanels {\\n        name\\n        iframe {\\n          addonKey\\n          moduleKey\\n          options\\n        }\\n      }\\n      \\n      contextPanels {\\n        name\\n        iframe {\\n          addonKey\\n          moduleKey\\n          options\\n        }\\n        icon {\\n          url\\n        }\\n        content\\n        status\\n        type\\n      }\\n      forge {\\n        panels {\\n          id\\n          instances {\\n            id\\n            collapsed\\n            added\\n          }\\n        }\\n      }\\n    }\\n\\n        \\n    \\n    contentPanels {\\n        edges {\\n            node {\\n                \\n    name\\n    addonKey\\n    moduleKey\\n    options\\n    iconUrl\\n    tooltip\\n    type\\n    isShownByDefault\\n    wasManuallyAddedToIssue\\n\\n            }\\n        }\\n    }\\n\\n    \\n    legacyContentPanels {\\n        edges {\\n            node {\\n                \\n    name\\n    addonKey\\n    moduleKey\\n    options\\n    iconUrl\\n    tooltip\\n    type\\n    isShownByDefault\\n    wasManuallyAddedToIssue\\n\\n            }\\n        }\\n    }\\n\\n    hasCustomisedContentPanels\\n\\n        \\n        glancesField {\\n          fieldKey\\n          value {\\n            name\\n            status\\n            iframe {\\n              addonKey\\n              moduleKey\\n              options\\n            }\\n            icon {\\n              url\\n            }\\n            content\\n            type\\n          }\\n        }\\n      \\n        attachments(orderDirection: DESC, orderField: CREATED, maxResults: 12) {\\n        nodes {\\n          id\\n          filename\\n          mimetype\\n          mediaApiFileId\\n          createdDate\\n          filesize\\n          parentName\\n          author {\\n              accountId\\n          }\\n          parentId\\n          hasRestrictedParent\\n        }\\n        totalCount\\n        deletableCount\\n      }\\n\\n        \\ncontainersByType(input:{systemContainerTypes: [CONTENT, PRIMARY, SECONDARY, REQUEST_PORTAL], supportDefaultTab: true}) {\\n__typename\\n... on JiraIssueItemContainers {\\ncontainers {\\n  containerType\\n  items {\\n    nodes {\\n      type: __typename\\n      ... on JiraIssueItemFieldItem {\\n        fieldItemId        \\n      }\\n      ... on JiraIssueItemPanelItem {\\n        panelItemId\\n      }\\n      ... on JiraIssueItemTabContainer {\\n        name\\n        tabContainerId              \\n        items {\\n          nodes {\\n            type: __typename\\n            ... on JiraIssueItemFieldItem {\\n              fieldItemId\\n            }\\n          }\\n        }\\n      }\\n    }\\n  }\\n}\\n}\\n}\\n\\n        \\n    remoteLinks {\\n        isLinkingEnabled\\n        remoteLinkedIssues {\\n            preview {\\n
            String jsonBody="{\"fields\":[\"status\"]}";
            System.out.println("JSON Body 👀:");
            System.out.println(jsonBody);
            // Construct the HTTP request
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(apiUrl);
            // Set headers
            request.addHeader("Content-Type", "application/json");
            request.addHeader("X-Acpt", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJpYXQiOjE3MDkwMzk5ODcsInN1YiI6IjcxMjAyMDoxOWRiNjRlMy1iZjc1LTRhM2MtOTczYi1kYmNhMzNlN2JhNmQiLCJleHAiOjE3MDkxMjYzODcsImF1ZCI6WyI3Y2ViM2E1Ny0yNmI4LTM2MjItODJhZi1lM2IzYmVmNDE3ZGQiXSwiY29udGV4dCI6eyJsaWNlbnNlIjp7ImFjdGl2ZSI6dHJ1ZX0sImppcmEiOnsiaXNzdWUiOnsiaXNzdWV0eXBlIjp7ImlkIjoiMTAwMzAifSwia2V5IjoiWERJLTMwMzAyIiwiaWQiOiIxMzc0NDcifSwicHJvamVjdCI6eyJrZXkiOiJYREkiLCJpZCI6IjEwMDI2In19fX0.gdgs2VoAs8ESbtkdxl5NLKIMxfy9KWKyMUqIKTcuf2E");

            // Set the JSON body
            StringEntity requestBody = new StringEntity(jsonBody);
            request.setEntity(requestBody);

            // Send the HTTP POST request
            HttpResponse response = httpClient.execute(request);

            // Handle the response
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            ParseJsonResponse(responseBody);

            // Close resources
            EntityUtils.consume(responseEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //naming method
    public static void uploadResultsToXray(){
        // Construct the URL for importing test execution results into Xray
        String apiUrl = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber";

        try {
            AppConstants.Token="Bearer "+GenerateToken();
            // Read JSON file content as a String
            String inputFilePath = System.getProperty("user.dir") + "/target/CucumberResults.json";

            // Output JSON file path
            String outputFilePath = System.getProperty("user.dir") + "/target/FilteredResults.json";

            // Read the JSON file
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode rootNode = objectMapper.readTree(new File(inputFilePath));

            // Filter scenarios
            ArrayNode filteredFeatures = JsonScenarioFilter.filterScenarios(rootNode, objectMapper);

            // Write the filtered features to a new JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), filteredFeatures);

            System.out.println("Filtered results written to: " + outputFilePath);
            String jsonBody = new String(Files.readAllBytes(Paths.get(outputFilePath)), StandardCharsets.UTF_8);
            System.out.println("JSON Body:");
            System.out.println(jsonBody);
            // Construct the HTTP request
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(apiUrl);
            // Set headers
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Authorization", AppConstants.Token );

            // Set the JSON body
            StringEntity requestBody = new StringEntity(jsonBody);
            request.setEntity(requestBody);

            // Send the HTTP POST request
            HttpResponse response = httpClient.execute(request);

            // Handle the response
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            //Print Response
            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            JSONObject jsonResponse = new JSONObject(responseBody);
            executionID = (String) jsonResponse.get("id");
            executionKey=(String) jsonResponse.get("key");
            // Close resources
            EntityUtils.consume(responseEntity);
            renameTestExecutionWithDate(executionKey);
            //FetchExecutionResults();
            // Link the Test Execution to the Test Plan
           // linkTestExecutionToTestPlan( testPlanKey, executionKey);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void renameTestExecutionWithDate(String executionKey) {
        // Correct Jira API base URL
        String jiraBaseUrl = "https://xray.cloud.getxray.app"; // Replace with your Jira instance
        String apiUrl = jiraBaseUrl + "/rest/api/2/issue/" + executionKey;

        try {
            // Generate or use existing token
            String token = "Bearer " + GenerateToken();

            // Get today's date in the desired format
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy"); // e.g., 22DEC2024
            String todayDate = dateFormat.format(new Date());

            // Construct the new name
            String newName = TestBase.environment + "-" + TestBase.platformName + "-UI Automation "
                    + TestBase.executionCycle + " Test Execution " + todayDate + "|283";

            // Construct the JSON payload
            JSONObject payload = new JSONObject();
            payload.put("fields", new JSONObject().put("summary", newName)); // Update summary

            // Create HTTP client and request
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut request = new HttpPut(apiUrl);

            // Set headers
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Authorization", token);

            // Set the request body
            StringEntity requestBody = new StringEntity(payload.toString());
            request.setEntity(requestBody);

            // Execute the request
            CloseableHttpResponse response = httpClient.execute(request);

            // Handle the response
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            if (statusCode == 200) {
                System.out.println("Test Execution renamed successfully to: " + newName);
            } else {
                System.err.println("Failed to rename Test Execution. Check the response.");
            }

            // Close resources
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void linkTestExecutionToTestPlan(String testPlanKey, String testExecutionKey) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        // Construct the API URL
        String apiLinkUrl = "https://xray.cloud.getxray.app/api/v2/testplan/" + testPlanKey + "/testexecution";
        AppConstants.Token="Bearer "+GenerateToken();
        // Create the HTTP client
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create the POST request
            HttpPost postRequest = new HttpPost(apiLinkUrl);
            postRequest.addHeader("Content-Type", "application/json");
            postRequest.addHeader("Authorization", "Bearer " +AppConstants.Token);

            // Construct the request body (adding the test execution)
            String jsonBody = "{ \"add\": [\"" + testExecutionKey + "\"] }";
            StringEntity requestEntity = new StringEntity(jsonBody);
            postRequest.setEntity(requestEntity);

            // Execute the request
            HttpResponse response = httpClient.execute(postRequest);

            // Check the response
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            if (statusCode == 200) {
                System.out.println("Successfully linked Test Execution to Test Plan.");
            } else {
                System.out.println("Failed to link Test Execution. Status Code: " + statusCode);
                System.out.println("Response: " + responseBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private static void linkTestExecutionToTestPlan(HttpClient httpClient, String testPlanKey, String executionKey) {
//        String apiLinkUrl = "https://xray.cloud.getxray.app/api/v2/testplan/" + testPlanKey + "/testexecution";
//        int maxRetries = 3;
//        int retryCount = 0;
//
//        while (retryCount < maxRetries) {
//            try {
//                HttpPost linkRequest = new HttpPost(apiLinkUrl);
//                linkRequest.addHeader("Content-Type", "application/json");
//                linkRequest.addHeader("Authorization", "Bearer " + AppConstants.Token);
//
//                String jsonLinkBody = "{ \"add\": [\"" + executionKey + "\"] }";
//                StringEntity linkRequestBody = new StringEntity(jsonLinkBody, StandardCharsets.UTF_8);
//                linkRequest.setEntity(linkRequestBody);
//
//                HttpResponse linkResponse = httpClient.execute(linkRequest);
//                int linkStatusCode = linkResponse.getStatusLine().getStatusCode();
//                String linkResponseBody = EntityUtils.toString(linkResponse.getEntity());
//
//                if (linkStatusCode == 503) {
//                    retryCount++;
//                    System.out.println("503 Service Unavailable. Retrying... Attempt " + retryCount);
//                    TimeUnit.SECONDS.sleep(2 * retryCount); // Exponential backoff
//                } else {
//                    System.out.println("Link Response Code: " + linkStatusCode);
//                    System.out.println("Link Response Body: " + linkResponseBody);
//                    break; // Exit loop if successful
//                }
//
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (retryCount == maxRetries) {
//            System.out.println("Failed to link Test Execution to Test Plan after " + maxRetries + " attempts.");
//        }
//    }

    public static void ParseJsonResponse(String response) {
        try {
            List<String> failedScenarios = new ArrayList<>();

            // Create ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Parse JSON array
            JsonNode arrayNode = mapper.readTree(response);

            // Iterate over JSON array elements
            for (JsonNode objNode : arrayNode) {
                String status = objNode.get("status").asText();
                String testIssueId = objNode.get("testIssueId").asText();
                System.out.println("status: " + status + ", testIssueId: " + testIssueId);
                if(status.equalsIgnoreCase("FAILED"))
                {
                    failedScenarios.add(testIssueId);
                }
                System.out.println( failedScenarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}