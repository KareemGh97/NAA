package Utilities.BrowserStack;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;

import Utilities.Reader.DataReaderManager;
import Utilities.commonClasses.AppConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BrowserStackDeviceFetcher {


    private static final String BROWSERSTACK_USERNAME = DataReaderManager.getValue("BrowserStackCredentials","browserstackUser");
    private static final String BROWSERSTACK_ACCESS_KEY = DataReaderManager.getValue("BrowserStackCredentials","browserstackKey");
    private static final String BROWSERSTACK_URL = "https://api.browserstack.com/automate/browsers.json";

    public static void parseAndStoreDevices() {
        try {
            // Fetch the list of supported devices
            String devicesJson = fetchSupportedDevices();

            // Parse and filter devices by iOS and Android version above 13
            parseAndStoreIosAndAndroidDevices(devicesJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String fetchSupportedDevices() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BROWSERSTACK_URL))
                .header("Authorization",
                        "Basic " + Base64.getEncoder().encodeToString(
                                (BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY).getBytes()))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch devices: " + response.statusCode());
        }
        return response.body();
    }

    public static void parseAndStoreIosAndAndroidDevices(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode devices = objectMapper.readTree(json);

        // Lists to store iOS and Android devices with version above 13
        ArrayList<String[]> iosDevices = new ArrayList<>();
        ArrayList<String[]> androidDevices = new ArrayList<>();

        for (JsonNode device : devices) {
            if (device.has("device")) { // Check for mobile or tablet
                String deviceName = device.get("device").asText();
                String os = device.get("os").asText();
                String osVersion = device.get("os_version").asText();
                boolean isRealMobile = device.get("real_mobile").asBoolean();

                // Filter only iOS devices with version above 13, exclude iPads and tablets
                if ("iOS".equalsIgnoreCase(os) && isRealMobile && isIosVersionAbove13(osVersion) && !deviceName.contains("iPad")) {
                    iosDevices.add(new String[]{deviceName, osVersion, "false"});
                }

                // Filter only Android devices with version above 13 and exclude tablets
                if ("Android".equalsIgnoreCase(os) && isRealMobile && isAndroidVersionAbove13(osVersion)&& !deviceName.contains("Tab")) {
                    androidDevices.add(new String[]{deviceName, osVersion, "false"});
                }
            }
        }

        // Convert lists to arrays
        AppConstants.iosDeviceArray = iosDevices.toArray(new String[0][0]);
        AppConstants.androidDeviceArray = androidDevices.toArray(new String[0][0]);

        // Store devices in variables (for parallel execution)
//        printDeviceArray("iOS Devices", AppConstants.iosDeviceArray);
//        printDeviceArray("Android Devices", AppConstants.androidDeviceArray);
    }

    // Helper method to print device array (for testing purposes)
    private static void printDeviceArray(String deviceType, String[][] deviceArray) {
        System.out.println(deviceType + ":");
        for (String[] device : deviceArray) {
            System.out.println(String.join(", ", device));
        }
    }

    // Helper method to check if the iOS version is greater than 13
    private static boolean isIosVersionAbove13(String osVersion) {
        try {
            int version = Integer.parseInt(osVersion.split("\\.")[0]); // Get major version
            return version > 13;
        } catch (NumberFormatException e) {
            return false; // In case the version is not a valid number
        }
    }

    // Helper method to check if the Android version is greater than 13
    private static boolean isAndroidVersionAbove13(String osVersion) {
        try {
            int version = Integer.parseInt(osVersion.split("\\.")[0]); // Get major version
            return version > 13;
        } catch (NumberFormatException e) {
            return false; // In case the version is not a valid number
        }
    }

    public static void updateSessionReason(String sessionID,String reason){

        System.out.println("in update session reason to BrowserStack: ");
        try {
            String apiUrl = "https://api-cloud.browserstack.com/app-automate/sessions/" + sessionID + ".json";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Authorization",
                            "Basic " + Base64.getEncoder().encodeToString(
                                    (BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY).getBytes()))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(reason))
                    .build();
            HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            System.out.println("Failed to update session reason to BrowserStack: " + e.getMessage());
        }
    }
}