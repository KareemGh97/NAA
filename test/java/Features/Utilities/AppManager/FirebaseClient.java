package Utilities.AppManager;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpHeaders;
import models.Fairebase.Release;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;


public class FirebaseClient {
    private final HttpTransport httpTransport;
    private final String serviceAccountPath;

    public FirebaseClient(String serviceAccountPath) {
        this.httpTransport = new NetHttpTransport();
        this.serviceAccountPath = serviceAccountPath;
    }

    public List<Release> getReleases(String platform) throws IOException {
        HttpResponse response = getBuilds(platform);
        String responseBody = response.parseAsString();
        return parseReleases(responseBody);
    }

    private HttpResponse getBuilds(String platform) throws IOException {
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
        GenericUrl url = buildUrl(platform);
        HttpRequest request = requestFactory.buildGetRequest(url);
        request.setHeaders(new HttpHeaders().setAuthorization("Bearer " + getAccessToken()));
        return request.execute();
    }

    private GenericUrl buildUrl(String platform) {
        String baseUrl = "https://firebaseappdistribution.googleapis.com/v1/projects/%s/releases";
        String platformPath = platform.equalsIgnoreCase("Android") ? "674317362236/apps/1:674317362236:android:a18af24176619105a70f39" : "674317362236/apps/1:674317362236:ios:ef606527b552e78aa70f39";
        return new GenericUrl(String.format(baseUrl, platformPath));
    }

    private String getAccessToken() throws IOException {
        GoogleCredentials credentials = GoogleCredentials
                .fromStream(new FileInputStream(serviceAccountPath))
                .createScoped(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
        credentials.refreshIfExpired();
        return credentials.getAccessToken().getTokenValue();
    }

    private List<Release> parseReleases(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        JsonNode releasesNode = root.get("releases");
        return mapper.readValue(releasesNode.toString(), new TypeReference<List<Release>>() {
        });
    }
}