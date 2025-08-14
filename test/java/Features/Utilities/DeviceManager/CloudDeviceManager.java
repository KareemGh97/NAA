package Utilities.DeviceManager;


import Utilities.BrowserStack.BrowserStackDeviceFetcher;
import Utilities.commonClasses.AppConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CloudDeviceManager {

    public static void fetchAndStoreAppAutomateBrowserStackDevices(){
        BrowserStackDeviceFetcher.parseAndStoreDevices();
    }

    public static final ThreadLocal<String[]> selectedCloudDevice = new ThreadLocal<>();

    public static synchronized String[] randomlySelectDevice(String[][] devices) {

        List<String[]> deviceList = Arrays.asList(devices);
        Collections.shuffle(deviceList); // Shuffle to introduce randomness
        selectedCloudDevice.set(deviceList.get(0));
        return deviceList.get(0);

    }
    public static void selectDeviceType(String platformName) {
        switch (platformName.toLowerCase()) {
            case "android" -> CloudDeviceManager.randomlySelectDevice(AppConstants.androidDeviceArray);
            case "ios" -> CloudDeviceManager.randomlySelectDevice(AppConstants.iosDeviceArray);
            default -> throw new IllegalArgumentException("Unsupported platformName: " + platformName);
        }

    }

    public static void releaseDevice() {
        String[] device = selectedCloudDevice.get();
        if (device != null) {
            device[2] = "false"; // Reset isSelected flag to false
            selectedCloudDevice.remove(); // Clear ThreadLocal after resetting
        }
    }

}
