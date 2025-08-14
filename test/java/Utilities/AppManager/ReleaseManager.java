package Utilities.AppManager;

import java.io.IOException;
import java.util.*;

import models.Fairebase.Release;

public class ReleaseManager {

    private List<Release> sitReleases = new ArrayList<>();
    private List<Release> uatReleases = new ArrayList<>();
    private List<Release> redesignReleases = new ArrayList<>();

    public void processReleases(List<Release> releases){
        releases.sort(Comparator.comparing((Release r) -> r.createTime).reversed());

        for (Release release : releases) {
            if (release.buildVersion > 350)
                sitReleases.add(release);
            else if (release.buildVersion < 200) {
                redesignReleases.add(release);
            } else {
                uatReleases.add(release);
            }
        }
    }

    public Release getLatestRelease(String environment) {
        return switch (environment.toLowerCase()) {
            case "sit" -> sitReleases.isEmpty() ? null : sitReleases.get(0);
            case "uat" -> uatReleases.isEmpty() ? null : uatReleases.get(0);
            default -> redesignReleases.isEmpty() ? null : redesignReleases.get(0);
        };
    }
}