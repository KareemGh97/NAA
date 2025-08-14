package Utilities.DeviceManager;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocalDevices {

    private final String platformName;
    private final String udid;
    private final String deviceName;
    private final String platformVersion;
    private boolean inUse;

    public LocalDevices(String platformName, String udid, String modelName, String platformVersion) {
        this.udid = udid;
        this.platformName = platformName;
        this.deviceName = modelName;
        this.platformVersion = platformVersion;
        this.inUse = false;
    }

//    public void setInUse(boolean inUse) {
//        this.inUse = inUse;
//    }

    @Override
    public String toString() {
        return platformName + " " + udid + " " + deviceName + " " + platformVersion + " " + inUse;
    }
}

