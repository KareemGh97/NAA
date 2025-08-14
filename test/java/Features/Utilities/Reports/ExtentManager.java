package Utilities.Reports;

import TestBases.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentManager extends TestBase {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mm");

    private static final String REPORTS_DIRECTORY = "UI_Extent_TestReports";
    private static final ConcurrentHashMap<String, ExtentReports> extentReportsMap = new ConcurrentHashMap<>();
    private static final ThreadLocal<String> reportFileNameThreadLocal = new ThreadLocal<>();

    private static synchronized ExtentReports createInstance(String identifier) throws UnknownHostException {
        ExtentReports extent;
        String reportFilePath = determineReportFilePath(identifier);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Execution Report");
        sparkReporter.config().setEncoding("UTF-8");
        sparkReporter.config().setReportName("Automation Test Execution Report");


        // Custom CSS: Hide steps by default and style scenario nodes as clickable.
        String customCss = ".scenario-container { display: flex; flex-direction: row; } " + ".scenario-metadata { flex: 0 0 40%; margin-right: 20px; } " + ".scenario-steps { flex: 1; } " + ".scenario-collapsed > ul.child { display: none; }";

        // Custom JS: Toggle scenario steps on click
        String customJs = "document.addEventListener('DOMContentLoaded', function() {" + "  document.querySelectorAll('.scenario-node').forEach(function(el) {" + "    let node = el.closest('li.node');" + "    if (node) {" + "      node.classList.add('scenario-collapsed');" + // start collapsed
                "      el.addEventListener('click', function() {" + "        node.classList.toggle('scenario-collapsed');" + "      });" + "    }" + "  });" + "});";

        sparkReporter.config().setCss(customCss);
        sparkReporter.config().setJs(customJs);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Execution Type", deployment);
        extent.setSystemInfo("Environment", environment);
        extent.setSystemInfo("Platform", platformName);
        extent.setSystemInfo("Version", version);

        return extent;
    }

    private static String determineReportFilePath(String identifier) {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String timeMinutsStamp = LocalDateTime.now().format(TIME_FORMATTER);
        String reportFileName = String.format(environment + "_UI_AutomationReport_%s.html", timestamp+"_"+timeMinutsStamp);
        String newFileName = reportFileName.replace(":","-");
        String baseDirectory = System.getProperty("user.dir");
        Path reportDirectoryPath = Paths.get(baseDirectory, REPORTS_DIRECTORY, environment + timestamp);

        createReportDirectory(reportDirectoryPath);
        String reportFilePath = reportDirectoryPath.resolve(newFileName).toString();
        reportFileNameThreadLocal.set(reportFilePath);
        return reportFilePath;
    }

    private static void createReportDirectory(Path path) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path);
                System.out.println("Report directory created at: " + path);
            } else {
                System.out.println("Report directory already exists at: " + path);
            }
        } catch (IOException e) {
            System.err.println("Failed to create report directory: " + path);
            e.printStackTrace();
        }
    }

    public static void openReportAfterExecution() {
        try {
            String reportPath = reportFileNameThreadLocal.get();
            if (reportPath != null) {
                File htmlFile = new File(reportPath);
                if (htmlFile.exists()) {
                    Desktop.getDesktop().browse(htmlFile.toURI());
                    System.out.println("Report opened successfully: " + reportPath);
                } else {
                    System.err.println("Report file does not exist: " + reportPath);
                }
            } else {
                System.err.println("Report file path is not set.");
            }
        } catch (IOException e) {
            System.err.println("Failed to open the report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ExtentReports getExtentReports() {
        String key = "determineReportKey";
        return extentReportsMap.computeIfAbsent(key, k -> {
            try {
                String identifier = "determineReportIdentifier";
                return createInstance(identifier);
            } catch (UnknownHostException e) {
                throw new RuntimeException("Failed to create ExtentReports instance for key: " + k, e);
            }
        });
    }
}
