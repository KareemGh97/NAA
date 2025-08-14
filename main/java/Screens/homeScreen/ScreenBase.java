package Screens.homeScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.NoSuchElementException;

public abstract class ScreenBase {
    public WebDriverWait wait;
    public AppiumDriver driver;
    public int scrollLimit = 50;
    public static String deployment;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenBase.class);

    public ScreenBase(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(20)), this);
        driver = appiumDriver;
    }

    public void tapOn(@NotNull WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));
            element.click();
            LOGGER.info("Tapped on element: {}", element);
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
            logError("Failed to tap on element", e);
            throw new NoSuchElementException(e.toString());
        } catch (org.openqa.selenium.TimeoutException ignored) {

        }
    }

    public void clearTextFrom(@NotNull WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));
            element.clear();
            LOGGER.info("Cleared text from element: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to clear text from element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void typingTextIn(WebElement element, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));

            waitUntilElementAppear(element, 10);
            clearTextFrom(element);
            element.sendKeys(value);
            LOGGER.info("Typed text '{}' in element: {}", value, element);
        } catch (NoSuchElementException e) {
            logError("Failed to type text in element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void verticalScroll(@NotNull WebElement element, double startPointYaxis, double endPointYaxis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)
        ));
        int centerX = element.getRect().x + (element.getSize().width / 2);
        double startY = element.getRect().y + (element.getSize().height * startPointYaxis);
        double endY = element.getRect().y + (element.getSize().height * endPointYaxis);
        performScroll(centerX, (int) startY, centerX, (int) endY);
    }


    public void horizontalScroll(@NotNull WebElement element, double startPointXAxis, double endPointXAxis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)
        ));
        int centerY = element.getRect().y + (element.getSize().height / 2);
        double startX = element.getRect().x + (element.getSize().width * startPointXAxis);
        double endX = element.getRect().x + (element.getSize().width * endPointXAxis);
        performScroll((int) startX, centerY, (int) endX, centerY);
    }

    private void performScroll(int startX, int startY, int endX, int endY) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(0));
            driver.perform(Collections.singletonList(swipe));
            LOGGER.info("Performed scroll from ({}, {}) to ({}, {})", startX, startY, endX, endY);
        } catch (NoSuchElementException e) {
            logError("Failed to perform scroll", e);
            throw new NoSuchElementException(e.toString());
        }
    }


    public void horizontalScrollOnScreen(double startPointXAxis, double endPointXAxis) {
        // Get screen dimensions
        Dimension screenSize = driver.manage().window().getSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Calculate Y-coordinate for the scroll (middle of the screen)
        int centerY = screenHeight / 2;

        // Calculate start and end X coordinates based on percentages
        int startX = (int) (screenWidth * startPointXAxis);
        int endX = (int) (screenWidth * endPointXAxis);

        // Perform the scroll
        performScroll(startX, centerY, endX, centerY);
    }


    public void longPressOn(@NotNull WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));
            Point elementLocation = element.getLocation();
            int x = elementLocation.x / 3;
            int y = elementLocation.y / 4;
            performLongPress(x, y);
            LOGGER.info("Performed long press on element: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to perform long press on element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    private void performLongPress(int x, int y) {
        try {

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "fingerTwo");
            Sequence longPress = new Sequence(finger, 1);
            longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
            longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            longPress.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), x, y));
            longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(longPress));
            LOGGER.info("Performed long press at ({}, {})", x, y);
        } catch (NoSuchElementException e) {
            logError("Failed to perform long press", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public String getText(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));
            String text = element.getText();
            LOGGER.info("Retrieved text from element: {} -> {}", element, text);
            return text;
        } catch (NoSuchElementException e) {
            logError("Failed to get text from element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        try {
            // Wait for the elements to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            sourceElement = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(sourceElement)
            ));
            targetElement = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(targetElement)
            ));

            // Define a finger for touch input
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            // Create the drag and drop sequence
            Sequence dragAndDrop = new Sequence(finger, 1).addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElement.getLocation().getX(), sourceElement.getLocation().getY())) // Move to the source element
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) // Long press on the source element
                    .addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), targetElement.getLocation().getX(), targetElement.getLocation().getY())) // Move to the target element
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Release at the target element

            // Perform the sequence on the driver
            driver.perform(Collections.singletonList(dragAndDrop));
        } catch (NoSuchElementException e) {
            logError("Failed to perform drag and drop", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void scrollThenTapOnElementByText(List<WebElement> webElements, String arabicText, String englishText, WebElement container) {
        try {
            String prevPageSource = "";
            boolean found = false;

            while (!isEndOfPage(prevPageSource)) {
                prevPageSource = driver.getPageSource();

                for (WebElement element : webElements) {
                    //todo one for onboarding without break,
                    // check if it fixed from FE team
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    element = wait.until(ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(element)
                    ));
                    String elementText = element.getText();
                    if (elementText.equalsIgnoreCase(englishText) || elementText.equalsIgnoreCase(arabicText)) {
                        element.click();
                        found = true;
                        LOGGER.info("Tapped on element with text: {}", elementText);
                        break;
                    }
                }
                if (found) {
                    break;
                }
                verticalScroll(container, 0.9, 0.5);
            }

        } catch (NoSuchElementException e) {
            logError("Element not found: " + webElements, e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void zoomOut(@NotNull WebElement element) {
        try {
            int centerX = element.getRect().x + (element.getSize().width / 2);
            int centerY = element.getRect().y + (element.getSize().height / 2);
            int movement = 300;

            zoom(centerX, centerY, movement, true);
            LOGGER.info("Zoomed out on element: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to zoom out on element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void zoomIn(@NotNull WebElement element) {
        try {
            int centerX = element.getRect().x + (element.getSize().width / 2);
            int centerY = element.getRect().y + (element.getSize().height / 2);
            int movement = 300;

            zoom(centerX, centerY, movement, false);
            LOGGER.info("Zoomed in on element: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to zoom in on element", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    private void zoom(int centerX, int centerY, int movement, boolean zoomOut) {
        try {
            int fingerOneStart = centerX - (zoomOut ? 2 * movement : movement);
            int fingerTwoStart = centerX + (zoomOut ? 2 * movement : movement);
            int fingerOneEnd = centerX - (zoomOut ? movement : 2 * movement);
            int fingerTwoEnd = centerX + (zoomOut ? movement : 2 * movement);

            PointerInput fingerOne = new PointerInput(PointerInput.Kind.TOUCH, "fingerOne");
            Sequence swipeOne = new Sequence(fingerOne, 1);
            swipeOne.addAction(fingerOne.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), fingerOneStart, centerY));
            swipeOne.addAction(fingerOne.createPointerDown(0));
            swipeOne.addAction(fingerOne.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), fingerOneEnd, centerY));
            swipeOne.addAction(fingerOne.createPointerUp(0));

            PointerInput fingerTwo = new PointerInput(PointerInput.Kind.TOUCH, "fingerTwo");
            Sequence swipeTwo = new Sequence(fingerTwo, 1);
            swipeTwo.addAction(fingerTwo.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), fingerTwoStart, centerY));
            swipeTwo.addAction(fingerTwo.createPointerDown(0));
            swipeTwo.addAction(fingerTwo.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), fingerTwoEnd, centerY));
            swipeTwo.addAction(fingerTwo.createPointerUp(0));

            driver.perform(Arrays.asList(swipeOne, swipeTwo));
            LOGGER.info("Performed zoom action at center ({}, {}) with movement {} zoomOut: {}", centerX, centerY, movement, zoomOut);
        } catch (NoSuchElementException e) {
            logError("Failed to perform zoom", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void switchToggle(@NotNull WebElement element, boolean desiredState) {
        try {
            boolean currentState = element.isSelected();
            if (currentState == desiredState) {
                LOGGER.info("Element is already in the desired state: {}", desiredState);
            } else {
                element.click();
                LOGGER.info("Element state changed to: {}", desiredState);
            }
        } catch (NoSuchElementException e) {
            logError("Failed to toggle the switch", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public boolean isEndOfPage(@NotNull String pageSource) {
        return pageSource.equals(driver.getPageSource());
    }

    public void useNativeKeyboard(String input) {
        try {
            String platformName = String.valueOf(driver.getCapabilities().getPlatformName());
            switch (platformName) {
                case "ANDROID" -> handleAndroidInput(input);
                case "IOS" -> handleIOSInput(input);
                default ->
                        throw new UnsupportedOperationException("Invalid platform: " + driver.getCapabilities().getPlatformName());
            }
        } catch (NoSuchElementException e) {
            logError("Failed to use native keyboard", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    private void handleAndroidInput(@NotNull String input) {
        AndroidDriver androidDriver = (AndroidDriver) driver;
        for (char ch : input.toCharArray()) {
            AndroidKey androidKey = getAndroidKey(ch);
            if (androidKey != null) {
                androidDriver.pressKey(new KeyEvent(androidKey));
                LOGGER.info("Pressed Android key: {}", androidKey);
            } else {
                LOGGER.warn("Unsupported character for Android: {}", ch);
            }
        }
    }

    private @Nullable AndroidKey getAndroidKey(char ch) {
        if (Character.isDigit(ch)) {
            return AndroidKey.valueOf("DIGIT_" + ch);
        } else if (Character.isLetter(ch)) {
            return AndroidKey.valueOf(String.valueOf(ch).toUpperCase());
        } else if (ch == '.') {
            return AndroidKey.PERIOD;
        }
        // Add more special character mappings as needed
        return null;
    }

    private void handleIOSInput(@NotNull String input) {
        IOSDriver iosDriver = (IOSDriver) driver;
        for (char ch : input.toCharArray()) {
            String key = Character.toString(ch);
            try {
                WebElement keyElement = iosDriver.findElement(By.id(key));
                keyElement.click();
                LOGGER.info("Clicked iOS key: {}", key);
            } catch (NoSuchElementException e) {
                LOGGER.warn("Key not found for iOS: {}", ch);
            }
        }
    }

    public void waitUntilElementAppear(WebElement element, int waitingTime) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
            wait.until(ExpectedConditions.visibilityOf(element));
            LOGGER.info("Waited until element appeared: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to wait until element appeared", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void waitUntilElementsAppear(List<WebElement> elements, int waitingTime) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            LOGGER.info("Waited until elements appeared");
        } catch (NoSuchElementException e) {
            logError("Failed to wait until elements appeared", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void waitUntilElementToBeClickable(WebElement element, int waitingTime) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            LOGGER.info("Waited until element was clickable: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to wait until element was clickable", e);
            throw new NoSuchElementException(e.toString());

        }
    }

    public void fluentWaitUntilElementAppear(WebElement element, int waitingTime) {
        try {
            FluentWait<AppiumDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(waitingTime)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
            wait.until(driver -> element.isDisplayed());
            LOGGER.info("Fluently waited until element appeared: {}", element);
        } catch (NoSuchElementException e) {
            logError("Failed to fluently wait until element appeared", e);
            throw new NoSuchElementException(e.toString());
        }
    }

    public void pressEnter() {
        try {
            String platformName = driver.getCapabilities().getPlatformName().toString();

            if (platformName.equalsIgnoreCase("Android")) {
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
                LOGGER.info("Pressed Enter key on Android");
            } else if (platformName.equalsIgnoreCase("iOS")) {
                JavascriptExecutor js = driver;
                js.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
                LOGGER.info("Pressed Return key on iOS using JavaScript");

            } else {
                // for other platforms
                driver.findElement(By.id("Return")).click();
                LOGGER.info("Pressed Return key using fallback method");
            }
        } catch (Exception e) {
            logError("Failed to press Enter/Return key", e);
            throw new RuntimeException("Failed to press Enter/Return key: " + e.getMessage(), e);
        }
    }

    public int getListSize(List<WebElement> elements) {
        try {
            return elements.size();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }


    public double currencyAmountFromString(String amountText) {
        String[] parts = amountText.trim().split("\\s+");
        return Double.parseDouble(parts[0].replace(",", ""));
    }

    public void pressNativeNumberPad(String action) {
        switch (driver.getCapabilities().getPlatformName()) {
            case ANDROID -> {

                AndroidDriver androidDriver = (AndroidDriver) driver;
                if (action.equalsIgnoreCase("delete")) {
                    for (int i = 0; i < 4; i++) {
                        androidDriver.pressKey(new KeyEvent(AndroidKey.DEL));
                    }
                    break;
                }

                for (int i = 0; i < action.length(); i++) {
                    char digit = action.charAt(i);
                    if (digit >= '0' && digit <= '9') {
                        int offset = digit - '0';
                        AndroidKey androidKey = AndroidKey.valueOf("DIGIT_" + offset);
                        androidDriver.pressKey(new KeyEvent(androidKey));
                    } else if (digit == '.') {
                        androidDriver.pressKey(new KeyEvent(AndroidKey.PERIOD));
                    }
                }
                androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
            }
            case IOS -> {

                IOSDriver iosDriver = (IOSDriver) driver;

                if (action.equalsIgnoreCase("delete")) {
                    for (int i = 0; i < 4; i++) {
                        iosDriver.findElement(By.xpath("//XCUIElementTypeKey[@name=\"Delete\"]")).click();
                    }
                    break;
                }
                for (int i = 0; i < action.length(); i++) {
                    char digit = action.charAt(i);
                    if (Character.isDigit(digit)) {
                        iosDriver.findElement(By.id(Character.toString(digit))).click();
                    } else if (digit == '.') {
                        iosDriver.findElement(By.xpath("//XCUIElementTypeKey[@name=\".\"]")).click();
                    }
                }
                try {
                    iosDriver.findElement(By.id("Done")).click();
                } catch (NoSuchElementException ignored) {
                    System.out.println("No Done option available on the key pad of iOS");
                }
            }
            default -> System.out.println("Invalid platform");
        }
    }

    public void retryWaitElement(WebElement element) {
        int retries = 0;
        int maxRetries = 3;
        int delay = 2000;  // Delay in milliseconds
        while (retries < maxRetries) {
            try {
                // Attempt to find the element and click
                waitUntilElementAppear(element, 20);
                break;  // Exit loop if successful
            } catch (NoSuchElementException | TimeoutException ignored) {
                retries++;
                System.out.println("Attempt " + retries + " failed: ");
                if (retries == maxRetries) {
                    System.out.println("Max retries reached. Operation failed.");
                    break;
                }
                ScreenBase.ThreadSleep(delay);
            }
        }
    }

    private void logError(String message, Exception e) {
        LOGGER.error("{} - Error: {}", message, e.getMessage(), e);
    }

    public boolean isDisplayed(@NotNull WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void assertElementIsDisplayed(WebElement element, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed(), elementName.replaceAll("(.)([ A-Z])", "$1 $2") + "expected [Displayed] but found [Not Displayed]");
        } catch (Exception e) {
            Assert.fail(elementName.replaceAll("(.)([ A-Z])", "$1 $2") + " expected [Displayed] but found [Not Displayed]");
        }
    }

    public void assertElementIsEnabled(WebElement element, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isEnabled(), elementName.replaceAll("(.)([ A-Z])", "$1 $2") + " expected [Enabled] but found [Disabled]");
        } catch (Exception e) {
            Assert.fail(elementName.replaceAll("(.)([ A-Z])", "$1 $2") + " expected [Enabled] but found [Disabled]");
        }
    }

    public void swipeToPickerWheelValue(WebElement pickerWheel, String targetValue) {
        try {
            // Maximum attempts to prevent infinite swiping
            int maxAttempts = 4;
            int attempt = 0;

            // Get the current value of the picker wheel
            String currentValue = pickerWheel.getAttribute("value");
            System.out.println(currentValue);
            // Loop until the target value is reached or max attempts are reached
            while (!currentValue.equals(targetValue) && attempt < maxAttempts) {
                attempt++;

                // Determine swipe direction based on comparison
//                String direction = currentValue.compareTo(targetValue) < 0 ? "up" : "down";
                String direction = "up";
                // Prepare swipe parameters
                Map<String, Object> swipeParams = new HashMap<>();
                swipeParams.put("direction", direction);
                swipeParams.put("elementId", ((RemoteWebElement) pickerWheel).getId());
                swipeParams.put("duration", 1000); // Swipe duration in milliseconds (2 seconds)
                // Perform swipe
                driver.executeScript("mobile: swipe", swipeParams);

                // Wait briefly to allow the picker to stabilize
                ScreenBase.ThreadSleep(3000);

                // Update the current value after swiping
                currentValue = pickerWheel.getAttribute("value");
                System.out.println("After" + currentValue);
            }

            // Log results
            if (currentValue.equals(targetValue)) {
                System.out.println("Successfully selected value: " + targetValue);
            } else {
                System.err.println("Failed to find the target value within the limit of attempts.");
            }
        } catch (Exception e) {
            System.err.println("Error during picker wheel interaction: " + e.getMessage());
        }
    }

    // Helper method to swipe the picker wheel (up or down)
    public void selectDate(String month, String year, String day) {
        IOSDriver iosDriver = (IOSDriver) driver;
        List<WebElement> pickerWheel = iosDriver.findElements(By.className("XCUIElementTypePickerWheel"));

        for (int i = 0; i < pickerWheel.size(); i++) {
            if (i == 0)// Select the month picker wheel
            {
                swipeToPickerWheelValue(pickerWheel.get(0), month);
            }
            if (i == 1) // Select the day picker wheel
            {
                swipeToPickerWheelValue(pickerWheel.get(1), day);
            }
            if (i == 2)// Select the year picker wheel
            {
//                swipeToPickerWheelValue(pickerWheel.get(2), year);
            }
        }

    }

    public static void ThreadSleep(long millis) {
        if (deployment.equalsIgnoreCase("cloud")) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}