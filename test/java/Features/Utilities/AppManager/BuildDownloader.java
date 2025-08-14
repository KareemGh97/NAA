package Utilities.AppManager;

import models.Fairebase.Release;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

public class BuildDownloader {
    private final PropertiesManager propertiesManager;
    private final FirebaseClient firebaseClient;
    private final ReleaseManager releaseManager;

    public BuildDownloader(PropertiesManager propertiesManager, FirebaseClient firebaseClient) {
        this.propertiesManager = Objects.requireNonNull(propertiesManager);
        this.firebaseClient = Objects.requireNonNull(firebaseClient);
        this.releaseManager = new ReleaseManager();
    }

    public String downloadBuild(String platform, String environment) throws IOException {
        // Get releases and find latest one
        List<Release> releases = firebaseClient.getReleases(platform);
        releaseManager.processReleases(releases);
        Release latestRelease = releaseManager.getLatestRelease(environment);

        if (latestRelease == null) {
            throw new IOException("No releases found for environment: " + environment);
        }

        // CHECK if build exists in properties file
        String currentVersion = propertiesManager.getLocalBuildVersion(environment, platform);
        String filePath = buildFilePath(platform, environment, latestRelease.buildVersion.toString());

        // Only download if version changed
        if (!currentVersion.equals(latestRelease.buildVersion)) {
            downloadFile(latestRelease.binaryDownloadUri, filePath);
            // UPDATE properties file with new version
            propertiesManager.updateLocalBuildVersion(environment, platform, latestRelease.buildVersion.toString());
        }

        return filePath;
    }

    private String buildFilePath(String platform, String environment, String version) {
        String extension = platform.equalsIgnoreCase("android") ? ".apk" : ".ipa";
        return String.format("app/%s/%s/%s%s", platform.toLowerCase(), environment.toLowerCase(), version, extension);
    }

    private void downloadFile(String sourceUrl, String destinationPath) throws IOException {
        Path path = Paths.get(destinationPath);
        Files.createDirectories(path.getParent());

        try (InputStream in = new URL(sourceUrl).openStream()) {
            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}