package Utilities.commonClasses;

import Utilities.DeviceManager.LocalDevices;

import java.util.ArrayList;
import java.util.List;

public class AppConstants {
    //DB Connection
    public static String Token;
    public static String ServerIP;
    public static String Port;
    public static String ServiceName;
    public static String SITDB_ORCL_user;
    public static String SITDB_ORCL_password;
    public static String CustomerDetailsTableName;
    //Transfer
    public static Double TransferAmount;
    public static Double Balance_Before_Transfer;
    public static Double Balance_After_Transfer;
    public static String TransferType;
    public static ThreadLocal <String> OnboardMobileNumber=new ThreadLocal<>();
    public static ThreadLocal <String> OnboardNationalID=new ThreadLocal<>();
    public static ThreadLocal <String> Passcode=new ThreadLocal<>() ;
    public static ThreadLocal <String> cic=new ThreadLocal<>() ;

    public static boolean prevScenarioFailed;
    public static String accountNumber;

    public static String BillDesc;
    public static String ReferenceNum;
    public static String[] selectedDevice;

    // Update Customer National Address Info
    public static String District;
    public static String City;
    public static String Country;
    //Parallel Execution Devices
    public static String[][] iosDeviceArray = {
            // Tier 1 devices
            {"iPhone 15 Pro", "17"},
            {"iPhone 15", "17"},
            {"iPhone 14", "16"},
            {"iPhone 14 Pro", "16"},
            // Tier 2 devices
            {"iPhone 13", "15"},
            {"iPhone 13 Pro", "15"},
            {"iPhone 16", "18"},
    };

    public static String[][] androidDeviceArray = {
            // Tier 1 devices
            {"Samsung Galaxy S24", "14.0"},
            {"Samsung Galaxy S21", "11.0"},
            // Tier 2 devices
            {"Samsung Galaxy S23", "13.0"},
            {"Samsung Galaxy S22", "12.0"},
            {"Samsung Galaxy S21", "12.0"},
    };

    public static List<LocalDevices> connectedDeviceList = new ArrayList<>();

    public static String xrayExecutionId;

}
