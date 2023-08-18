package com.fadv.automation.core;

import io.github.sridharbandi.HtmlCsRunner;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.*;

import static org.testng.Assert.fail;

public class SeleniumBaseClass extends BaseClass {

    public final static String BROWSER_CHROME = "Chrome";
    public final static String BROWSER_EDGE = "Edge";
    public final static String BROWSER_FIREFOX = "Firefox";
    public final static String BROWSER_CHROME_IPHONE = "Chrome_iPhone";
    public final static String BROWSER_CHROME_NEXUS = "Chrome_Nexus";
    public final static String dryRun = System.getProperty("dryRun");
    public static final int IMPLICITLY_WAIT = 30;
    public static final String downloadFilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "downloads";

    public static WebDriver driver;
    public static HtmlCsRunner htmlCsRunner;
    public static String accessiblityPath;

    public static EventFiringWebDriver eventFiringWebDriver;
    public static EventListener eventListener;

    public SeleniumBaseClass(WebDriver driver) {
        this.driver = driver;
    }


    public static WebDriver initBrowser(String browser) throws Exception {
        String driverPath = null;
        String videoPath = null;

        // RemoteWebDriver driver = null;


        Map<String, Object> deviceMetrics = null;
        Map<String, Object> mobileEmulation = null;
        Map<String, Object> prefs = null;
        ChromeOptions chromeOptions = null;
        FirefoxOptions firefoxOptions = null;
        switch (browser) {
            case BROWSER_CHROME_NEXUS:
                driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);

                deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 360);
                deviceMetrics.put("height", 640);
                deviceMetrics.put("pixelRatio", 3.0);

                prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
                prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
                prefs.put("profile.default_content_setting_values.geolocation", 1);
                prefs.put("profile.default_content_setting_values.notifications", 1);

                mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("use-fake-device-for-media-stream");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");
                videoPath = System.getProperty("user.dir") + "/src/test/resources/testvideos/Device-video-for-automation.mjpeg";
                chromeOptions.addArguments("use-file-for-fake-video-capture=" + videoPath);


                if (dryRun != null) {
                    if (dryRun.equalsIgnoreCase("FALSE")) {
                        DesiredCapabilities caps = new DesiredCapabilities();
                        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                        driver = new RemoteWebDriver(new URL("http://10.74.141.78:4444/wd/hub"), caps);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                    } else {
                        driver = new ChromeDriver(chromeOptions);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        driver.manage().window().maximize();
                    }
                    //      htmlCsRunner = new HtmlCsRunner(driver);
                }
                break;
            case BROWSER_CHROME_IPHONE:
                driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);

                prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
                prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
                prefs.put("profile.default_content_setting_values.geolocation", 1);
                prefs.put("profile.default_content_setting_values.notifications", 1);

                deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 375);
                deviceMetrics.put("height", 812);
                deviceMetrics.put("pixelRatio", 3.0);

                mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) relesys_web_client/1.3.9.0 (RelesysApp/1.3.40; net.relesysapp.normal)");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("use-fake-device-for-media-stream");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");
                videoPath = System.getProperty("user.dir") + "/src/test/resources/testvideos/Device-video-for-automation.mjpeg";
                chromeOptions.addArguments("use-file-for-fake-video-capture=" + videoPath);

                if (dryRun != null) {
                    if (dryRun.equalsIgnoreCase("FALSE")) {
                        DesiredCapabilities caps = new DesiredCapabilities();
                        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                        driver = new RemoteWebDriver(new URL("http://10.74.141.78:4444/wd/hub"), caps);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                    } else {
                        driver = new ChromeDriver(chromeOptions);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        driver.manage().window().maximize();
                    }
                }
                //  htmlCsRunner = new HtmlCsRunner(driver);
                break;
            case BROWSER_CHROME:
                logger.info("start: setting chromedriver preferences.....");
                driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);
//              turning off camera for this option to use for file upload
                prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.media_stream_mic", 2);
                prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
                prefs.put("profile.default_content_setting_values.geolocation", 1);
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", downloadFilepath);
                prefs.put("browser.helperApps.neverAsk.saveToDisk", "application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel");
//                prefs.put("profile.default_content_setting_values.notifications", 1);

                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--browser.download.folderList=2");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("no-sandbox");
                chromeOptions.setExperimentalOption("prefs", prefs);
                if (dryRun != null) {
                    if (dryRun.equalsIgnoreCase("FALSE")) {
                        DesiredCapabilities caps = new DesiredCapabilities();
                        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                        driver = new RemoteWebDriver(new URL("http://10.74.141.78:4444/wd/hub"), caps);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        logger.info("Chrome: Remote Webdriver set for http://10.74.141.78:4444/wd/hub");
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                    } else if (dryRun.equalsIgnoreCase("TRUE")) {
                        driver = new ChromeDriver(chromeOptions);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        driver.manage().window().maximize();
                    }
                } else {
                    driver = new ChromeDriver(chromeOptions);
                    DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                    driver = DriverFactory.getInstance().getMultiDriver();
                    driver.manage().window().maximize();
                }
//                    htmlCsRunner = new HtmlCsRunner(driver);
                break;
            case BROWSER_FIREFOX:
                logger.info("start: setting firefox preferences preferences....");
                driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe";
//                downloadFilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "downloads";
                System.setProperty("webdriver.gecko.driver", driverPath);

                firefoxOptions = new FirefoxOptions();
                videoPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testvideos\\Device-video-for-automation.mjpeg";
                logger.info("video path: " + videoPath);
                firefoxOptions.addPreference("permissions.default.microphone", 1);
                firefoxOptions.addPreference("permissions.default.camera", 1);
                firefoxOptions.addPreference("media.navigator.streams.fake", true);
                firefoxOptions.addPreference("browser.download.dir", downloadFilepath);
                firefoxOptions.addArguments("use-file-for-fake-video-capture=" + videoPath);

                if (dryRun != null) {
                    if (dryRun.equalsIgnoreCase("FALSE")) {
                        DesiredCapabilities caps = new DesiredCapabilities();
                        driver = new RemoteWebDriver(new URL("http://10.74.141.78:4444/wd/hub"), caps);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        logger.info("Firefox: Remote Webdriver set for http://10.74.141.78:4444/wd/hub");
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        logger.info("file has been set for firefox browser...");
                    } else {
                        driver = new FirefoxDriver(firefoxOptions);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        logger.info("Setting driver to run locally...");
                        driver.manage().window().maximize();
                    }
                }
                // htmlCsRunner = new HtmlCsRunner(driver);
                break;
            case BROWSER_EDGE:
                driverPath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe";
                System.setProperty("webdriver.edge.driver", driverPath);
//                System.setProperty("webdriver.edge.verboseLogging", "true");
//                EdgeDriverService service = EdgeDriverService.createDefaultService();

                EdgeOptions options = new EdgeOptions();
                videoPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testvideos\\Device-video-for-automation.mjpeg";
                logger.info("video path: " + videoPath);
                options.addArguments("allow-file-access-from-files");
                options.addArguments("use-fake-device-for-media-stream");
                options.addArguments("use-fake-ui-for-media-stream");
                options.addArguments("--disable-features=EnableEphemeralFlashPermission");
                if (dryRun != null) {
                    if (dryRun.equalsIgnoreCase("FALSE")) {
                        DesiredCapabilities caps = new DesiredCapabilities();
                        driver = new RemoteWebDriver(new URL("http://10.74.141.78:4444/wd/hub"), caps);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        logger.info("Edge: Remote Webdriver set for http://10.74.141.78:4444/wd/hub");
                        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        logger.info("file has been set for Edge browser...");
                    } else {
                        driver = new EdgeDriver(options);
                        DriverFactory.getInstance().setMultiDriver((RemoteWebDriver) driver);
                        driver = DriverFactory.getInstance().getMultiDriver();
                        driver.manage().window().maximize();
                    }
                }
                //  htmlCsRunner = new HtmlCsRunner(driver);
                break;
            default:
                throw new RuntimeException("Browser not support [" + browser + "]");
        }
        logger.info("returning driver " + driver);
        htmlCsRunner = new HtmlCsRunner(driver);
        return driver;

    }


    public static WebDriver initWebDriverFromProperty(TestObject testObject) throws Exception {
        //default browser setting
        String selectedBrowser = "Chrome";
        WebDriver webDriver = null;
        // need to check if there's an existing driver object by the test
//        Object obj = testObject.getRuntimeData(Constants.WEBDRIVER);
//        if (obj != null && obj instanceof WebDriver) {
//            webDriver = (WebDriver)obj;
//        } else {
        try {
            //using system property
            String browser = System.getProperty("browser");
            if (browser != null && !browser.isEmpty()) {
                logger.info("using browser specified by system property " + browser);
                selectedBrowser = browser;
                webDriver = initBrowser(selectedBrowser);
                logger.info("webDriver selected: " + webDriver);
                return webDriver;
            } else {
                //using config file
                String configBrowser = testObject.getProperty("selenium.browser");
                if (configBrowser != null && !configBrowser.isEmpty()) {
                    logger.info("using browser specified by config file " + configBrowser);
                    selectedBrowser = configBrowser;
                    webDriver = initBrowser(selectedBrowser);
                    return webDriver;
                }
            }
        } catch (Exception ignored) {
            webDriver = initBrowser(selectedBrowser);
            return webDriver;
            //     testObject.setRuntimeData(Constants.WEBDRIVER, webDriver);
        }
        return webDriver;
    }


    public WebDriver setBrowserFromProperty(WebDriver webDriver) throws Exception {
        if (webDriver == null) {
            return initWebDriverFromProperty(testObject);
        }
        return webDriver;
    }


    /**
     * Get Selenium Driver
     *
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Capture Selenium screenshot and add to report
     *
     * @param name
     */
    public void reportScreenshot(String name) {
        if (testObject.getScenario().isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            testObject.getScenario().attach(screenshot, "image/png", name);
        }
    }


    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    public void closeCurrentTab() {
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
    }


    public void browserBackButton() {
        driver.navigate().back();
    }


    // Web driver methods //////////////////////////////////////////////////////////////
    public boolean exists(By by) {
        return exists(by, 30);
    }

    /**
     * this method is to verify if the element exists within the given time (seconds)
     *
     * @param by
     * @param second
     * @return true/false if the element exists
     */
    public boolean exists(By by, int second) {
        boolean exists = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
            WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            if (!ele.equals(null))
                exists = true;
//            new WebDriverWait(driver, Duration.ofSeconds(second));
        } catch (Exception e) {
            exists = false;
        }
        return exists;
    }

    /**
     * this method is to click on the given element.
     *
     * @param element
     */
    public void clickElement(By by) {
        try {
            if (exists(by, 15)) {
                driver.findElement(by).click();
                logger.info("Clicked On Element [" + by + "]");
            } else {
                logger.info("Tried to click On Element [" + by + "], but it doesn't exist, trying to find alternative locator");
                By altBy = WebElementHelper.getAlternativeLocators(eventFiringWebDriver, by);
                clickElement(altBy);
            }
        } catch (Exception e) {
            logger.info("Unable click on element: " + by + " cause of error: " + e);
            fail();
        }
    }

    public void clickElement(WebElement element) {
        if (element.isEnabled()) {
            element.click();
            logger.info("Clicked On Element [" + element + "]");
        } else {
            logger.info("Element [" + element + "], was not found or enabled.");
        }
    }

    public SearchContext expandRootElement(SearchContext element) {
        SearchContext ele = (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }


    public void openNewBrowserTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    /**
     * this method is to set the value of the given element
     *
     * @param element
     * @param value
     */
    public void setElementValue(By by, String value) {
        try {
            if (this.exists(by, 5)) {
                WebElement we = driver.findElement(by);
                we.clear();
                we.sendKeys(value);
                if (getAttribute(we, "value") == null) {
                    waitForSeconds(10);
                }
                if (!we.getAttribute("type").equalsIgnoreCase("password")) {
                    logger.info("Set value [**hidden, some xml with pw pass through here**] to Element [" + by + "]");
                } else {
                    logger.info("Set password value [**hidden**] to Element [" + by + "]");
                }
            } else {
                logger.info("Element [" + by + "] does not exist, trying to find alternative locator");
                By altBy = WebElementHelper.getAlternativeLocators(eventFiringWebDriver, by);
                setElementValue(altBy, value);
            }
        } catch (Exception e) {
            logger.info("Unable click on element: " + by + " cause of error: " + e);
            fail();
        }
    }

    public void jsSetElementValue(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        element.clear();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(value);
        clipboard.setContents(transferable, null);
        js.executeScript("arguments[0].setAttribute('value', 'arguments[1]')", element, value);
        waitForSeconds(15);
        for (int i = 0; i < 3; i++) {
            if (getAttribute(element, "value") == null) {
                waitForSeconds(10);
            } else {
                i = 99;
                break;
            }
        }
    }


    public void clipBoardSetElementValue(WebElement element, String value) {
        if (element.isDisplayed()) {
            element.clear();
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = new StringSelection(value);
            clipboard.setContents(transferable, null);
            element.sendKeys(Keys.CONTROL, "v");
            waitForSeconds(15);
            for (int i = 0; i < 3; i++) {
                if (getAttribute(element, "value") == null) {
                    waitForSeconds(10);
                } else {
                    i = 99;
                    break;
                }
            }
            if (!element.getAttribute("type").equalsIgnoreCase("password")) {
                logger.info("Set value [" + value + "] to Element [" + element + "]");
            } else {
                logger.info("Set password value [**hidden**] to Element [" + element + "]");
            }
        } else {
            throw new RuntimeException("Element [" + element + "] does not exist");
        }
    }


    public void setElementValueNoClear(By by, String value) {
        if (this.exists(by, 5)) {
            driver.findElement(by).sendKeys(value);
        } else {
            By altBy = WebElementHelper.getAlternativeLocators(eventFiringWebDriver, by);
            setElementValueNoClear(altBy, value);
        }

    }

    public void setElementValueWithClear(WebElement element, String value) {
        waitForElementPresent(element);
        element.clear();
        element.sendKeys(value);
    }


    public void setElementValueNoClear(WebElement element, String value) {
        waitForElementPresent(element);
        element.sendKeys(value);
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void javaScriptClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public boolean waitFor(By by) throws InterruptedException {
        return waitFor(by, 60);
    }

    public void waitForElementPresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * wait for element to disappear within the default timeout
     *
     * @param by
     * @return true/false
     * @throws InterruptedException
     * @see waitForDisappear
     */
    public boolean waitForDisappear(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * wait for element to disappear within the given time (second).
     *
     * @param by
     * @param second
     * @return true/false
     * @throws InterruptedException
     * @see waitForDisappear
     */

    public boolean waitForDisappear(By by, int second) throws InterruptedException {
        if (getDriver() == null) {
            return false;
        }

        boolean bReturn = false;
        int iWaited = 0;
        long end = System.currentTimeMillis() + (1000 * second);

        //getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        while (System.currentTimeMillis() < end) {
            if (exists(by, 1)) {
                WebElement result = null;
                try {
                    result = getDriver().findElement(by);
                    if (result != null && !result.isDisplayed()) {
                        bReturn = true;
                        break;
                    }
                } catch (Exception e) {
                }
                Thread.sleep(1000);
                iWaited++;
            } else {
                bReturn = true;
                break;
            }
        }
        logger.info("waited " + iWaited + " seconds for [" + by.toString() + "] to disappear, complete [" + bReturn + "]");
        return bReturn;
    }

    public boolean waitForDisappear(WebElement element, long second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementClickable(By by) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(by));
        waitForElementClickable(by, 420);
    }
    public void waitForElementClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForSeconds(Integer int1) {
        try {
            Thread.sleep(int1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public Boolean isElementEnabled(WebElement element) {
        logger.info("Checking if " + element + " is Enabled: " + element.isEnabled());
        return element.isEnabled();
    }

    /**
     * this method is to wait for the element to load, within the given timeout in seconds
     *
     * @param by
     * @param second
     * @return true/false
     * @throws InterruptedException
     */
    public boolean waitFor(By by, int second) throws InterruptedException {
        boolean bReturn = false;
        int iWaited = 0;
        long end = System.currentTimeMillis() + (1000 * second);
        while (System.currentTimeMillis() < end) {
            if (exists(by, 1)) {
                WebElement result = driver.findElement(by);
                if (result.isDisplayed()) {
                    bReturn = true;
                    break;
                }
            }
            Thread.sleep(1000);
            //wait(1);
            iWaited++;
        }

        if (iWaited > 0) {
            logger.info("waited " + iWaited + " seconds for [" + by.toString() + "] complete [" + bReturn + "]");
        }
        return bReturn;
    }

    /**
     * this method is to select the option from the web list / drop-down list.
     *
     * @param webList           the element web list
     * @param visibleTextOption the option to select
     */
    public void selectElement(By by, String visibleTextOption) {
        try {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(visibleTextOption);
            logger.info("weblist [" + by.toString() + "] selects [" + visibleTextOption + "]");
        } catch (NoSuchElementException e) {
            logger.info("Element by: " + by + " not found, trying to find alternative locator");
            By altBy = WebElementHelper.getAlternativeLocators(eventFiringWebDriver, by);
            selectElement(altBy, visibleTextOption);
        } catch (Exception e) {
            logger.info("Unable to select option: " + visibleTextOption + " in selection by: "
                    + by + " not found cause of: " + e);
        }
    }

    /**
     * this method is to check/uncheck the checkbox.
     *
     * @param checkbox
     * @param setChecked
     */
    public void checkbox(By checkbox, boolean setChecked) {
        try {
            WebElement cb = driver.findElement(checkbox);

            if (setChecked && !cb.isSelected()) {
                cb.click();
                logger.info("Checkbox [" + checkbox + "] is checked");
            } else if (cb.isSelected()) {
                cb.click();
                logger.info("Checkbox [" + checkbox + "] is NOT checked");
            }
        } catch (NoSuchElementException e) {
            By altBy = WebElementHelper.getAlternativeLocators(eventFiringWebDriver, checkbox);
            checkbox(altBy, setChecked);
        } catch (Exception e) {
            logger.info("Unable to set checkbox cause of: " + e);
        }
    }

    public boolean isExistAndDisplayed(WebDriver driver, By by, int second) {
        boolean bDisplayed;
        for (int i = 0; i < second; i++) {
            if (isExists(driver, by, 1)) {
                try {
                    WebElement element = driver.findElement(by);
                    bDisplayed = element.isDisplayed();
                    if (bDisplayed) {
                        logger.info("element [" + by + "] isDisplayed = " + bDisplayed);
                        return bDisplayed;
                    } else {
                        wait(1);
                        logger.info("wait for element is displayed");
                    }
                } catch (Exception e) {
                    logger.info("Unable to check" + by + "is displayed: " + e);
                }
            }
        }
        logger.info("Element by: " + by + " is not displayed for " + second + " seconds");
        return false;
    }

    public static boolean isExists(WebDriver driver, By by, int second) {
        boolean exists = false;

        for (int i = 0; i < second; i++) {
            try {
                if (driver.findElements(by).size() != 0) {
                    logger.info("Element found by: " + by);
                    return true;
                } else {
                    wait(1);
                    logger.info("Element not found by: " + by);
                }
            } catch (Exception e) {
                logger.info("Element not exists by: " + by);
            }
        }
        return exists;
    }

    public String getAttribute(WebElement element, String attributeText) {
        return element.getAttribute(attributeText);
    }

    public static void wait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
            logger.info("Waited for " + timeInSeconds + " seconds");

        } catch (Exception e) {
            logger.info("Failed - Error in function wait(): " + e.getMessage());
            logger.info("Failed - Error in function wait() - check logs for more details");
        }
    }

    public EventFiringWebDriver setEventDriver() {
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        setEventListener(eventFiringWebDriver);
        return eventFiringWebDriver;
    }


    public void setEventListener(EventFiringWebDriver eventFiringWebDriver) {
// Create an instance of your event listener class
        eventListener = new EventListener();

// Register the event listener
        eventFiringWebDriver.register(eventListener);
    }

    public static void setAttribute(WebDriver driver, By by, String attrName, String attrValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = driver.findElement(by);
        js.executeScript("arguments[0].setAttribute('" + attrName + "', '" + attrValue + "')", ele);
    }
//    public static void closeDriver(WebDriver driver) {
//        if (driver != null) {
//            driver.close();
//            driver.quit();
//        }
//    }

}
