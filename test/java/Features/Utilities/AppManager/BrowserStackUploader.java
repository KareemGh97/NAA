package Utilities.AppManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import models.Fairebase.Release;

import java.io.IOException;
import java.util.List;

public class BrowserStackUploader {
    private final PropertiesManager propertiesManager;
    private final FirebaseClient firebaseClient;
    private final ReleaseManager releaseManager;

    public BrowserStackUploader(PropertiesManager propertiesManager, FirebaseClient firebaseClient) {
        this.propertiesManager = propertiesManager;
        this.firebaseClient = firebaseClient;
        this.releaseManager = new ReleaseManager();
    }

    public String uploadToBrowserStack(String platform, String environment) throws IOException {
        // Get releases and find latest one
        List<Release> releases = firebaseClient.getReleases(platform);
        releaseManager.processReleases(releases);
        Release latestRelease = releaseManager.getLatestRelease(environment);

        if (latestRelease == null) {
            throw new IOException("No releases found for environment: " + environment);
        }

        // CHECK if build exists in properties file
        String currentVersion = propertiesManager.getBrowserStackBuildVersion(environment, platform);

        // Only upload if version changed
        if (!currentVersion.equals(latestRelease.buildVersion)) {
            String appUrl = postToBrowserStack(latestRelease.binaryDownloadUri);
            // UPDATE properties file with new version and URL
            propertiesManager.updateBrowserStackBuild(environment, platform,
                    latestRelease.buildVersion.toString(), appUrl);
            return appUrl;
        }

        // Return existing URL if no update needed
        return propertiesManager.getBrowserStackAppUrl(environment, platform);
    }

    private String postToBrowserStack(String binaryUrl) throws IOException {
        RestAssured.baseURI = "https://api-cloud.browserstack.com/app-automate";

        String username = propertiesManager.getBrowserStackUsername();
        String password = propertiesManager.getBrowserStackKey();

        Response response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .multiPart("url", binaryUrl)
                .post("/upload");

        String contentType = response.getHeader("Content-Type");

        if (contentType.contains("application/json")) {
            return response.path("app_url");
        } else if (contentType.contains("text/html")) {
            String responseString = response.asString();
            String jsonResponse = responseString.substring(
                    responseString.indexOf("{"),
                    responseString.indexOf("}") + 1
            );
            return JsonPath.from(jsonResponse).getString("app_url");
        }

        throw new RuntimeException("Unknown response format from BrowserStack: " + contentType);
    }
}