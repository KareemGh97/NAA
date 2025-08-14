package Utilities.media;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import static TestBases.DriverManager.getAppiumDriver;


public class CaptureScreenShot {

    public static String captureScreenshotOnFailure(String folderName, String screenshotName) {
        try {
            String sanitizedScreenshotName = screenshotName.replace("/", "-");
            File destination = new File("ExecutionMedia/screenshots/" + folderName + "/" + sanitizedScreenshotName + ".png");
            File screenshot = ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, destination);
            System.out.println("screenshot captured in " + destination.getAbsolutePath());
            return captureScreenshotAsBase64();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
        return null;
    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
