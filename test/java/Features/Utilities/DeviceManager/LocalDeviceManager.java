package Utilities.DeviceManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static Utilities.commonClasses.AppConstants.connectedDeviceList;

public class LocalDeviceManager {

    private static final Map<String, String> iosDeviceMap = new HashMap<>();

    static {
        // Mapping ProductType to actual iPhone Model Names
        iosDeviceMap.put("iPhone15,5", "iPhone 15 Plus");
        iosDeviceMap.put("iPhone15,4", "iPhone 15");
        iosDeviceMap.put("iPhone15,3", "iPhone 15 Pro Max");
        iosDeviceMap.put("iPhone15,2", "iPhone 15 Pro");
        iosDeviceMap.put("iPhone14,3", "iPhone 14 Pro");
        iosDeviceMap.put("iPhone14,5", "iPhone 14");
        iosDeviceMap.put("iPhone13,2", "iPhone 12");
        iosDeviceMap.put("iPhone12,1", "iPhone 11");
        // Add more mappings as needed
    }

    public static ThreadLocal<LocalDevices> selectedLocalDevice = new ThreadLocal<>();

    public static synchronized void randomlySelectDevice(List<LocalDevices> deviceList) {

        deviceList.stream()
                .filter(device -> !device.isInUse())
                .findFirst()
                .map(device -> {
                    device.setInUse(true); // Mark as in use
                    selectedLocalDevice.set(device);
                    return device;
                })
                .orElseThrow(() -> new RuntimeException("No available devices!"));
    }


    public static void getLocalConnectedDevices() throws IOException {

        Process process = Runtime.getRuntime().exec("adb devices -l");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.contains("List of devices attached") && line.length() > 3) {
                String[] parts = line.split("\\s+");
                String deviceId = parts[0];
                String model = executeCommand("adb -s " + deviceId + " shell getprop ro.product.model");
                String osVersion = executeCommand("adb -s " + deviceId + " shell getprop ro.build.version.release");
                if (model != null && osVersion != null)
                    connectedDeviceList.add(new LocalDevices("Android", deviceId, model.trim(), osVersion.trim()));
            }
        }

        // Get the list of connected iOS devices (UDIDs)
        List<String> udids = getConnectedUDIDs();

        // Loop through each UDID and fetch device details
        for (String udid : udids) {
            String productType = getDeviceInfo(udid, "ProductType");
            String iosVersion = getDeviceInfo(udid, "ProductVersion");

            // Convert ProductType to human-readable model name
            String model = iosDeviceMap.getOrDefault(productType, "Unknown iPhone");

            if (model != null )
                connectedDeviceList.add(new LocalDevices("iOS", udid, model.trim(), iosVersion.trim()));
        }

        if (connectedDeviceList.isEmpty()) {
            throw new RuntimeException("No connected devices found");
        }

    }

    private static String executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine(); // Read the first line only
    }

    private static List<String> getConnectedUDIDs() throws IOException {
        List<String> udids = new ArrayList<>();

        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "idevice_id -l"});
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                udids.add(line.trim());
            }
        }

        return udids;
    }

    // getting iOS devise information by the UDID
    private static String getDeviceInfo(String udid, String key) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c",
                "ideviceinfo -u " + udid + " | grep " + key + " | cut -d ':' -f2"});
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String result = reader.readLine();
        return result != null ? result.trim() : "Unknown";
    }
}

