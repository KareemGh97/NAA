package Utilities.media;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import static TestBases.DriverManager.getAppiumDriver;


public class RecordScreenVideo {


    //start recording
    public static void startRecording() {
        ((CanRecordScreen) getAppiumDriver()).startRecordingScreen();
    }

    public static void stopRecording(String folderName, String screenshotName) {
        try {
            // Stop video recording and get the base64-encoded video data
            String video = ((CanRecordScreen) getAppiumDriver()).stopRecordingScreen();

            // Decode the base64 video data
            byte[] decodedVideo = Base64.getDecoder().decode(video);

            String sanitizedScreenshotName = screenshotName.replace("/", "-");

            File directory = new File("ExecutionMedia/videos/" + folderName);
            if (!directory.exists()) {
                directory.mkdirs(); // Create folders if they don't exist
            }

            File testVideoFileLocation = new File(directory, sanitizedScreenshotName + ".mp4");

            try (FileOutputStream fos = new FileOutputStream(testVideoFileLocation)) {
                fos.write(decodedVideo);
            }
            Allure.addAttachment("video Recording","video/mp4",Files.newInputStream(testVideoFileLocation.toPath()),".mp4");
            AllureLifecycle lifecycle = Allure.getLifecycle();
            lifecycle.updateTestCase(testResult -> testResult.setStatus(Status.FAILED));

            System.out.println("Video saved successfully at: " + testVideoFileLocation.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save recorded video", e);
        }
    }
}
