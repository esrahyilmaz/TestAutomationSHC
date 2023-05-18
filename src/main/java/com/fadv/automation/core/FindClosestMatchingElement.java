package com.fadv.automation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static helpers.ReportHelper.customLogInfo;
//import static helpers.ReportHelper.logger.info;

public class FindClosestMatchingElement extends BaseClass {

    static String validPattern;
    static Pattern pattern;
    static Matcher tagMatcher;


    static String altXpathId;
    static String altXpathName;
    static String altXpathClass;
    static String altXpathText;

    /**
     * This method finds the best alternate match for the target element not found.
     *
     * @param _findByContext
     * @param storedClassName
     * @param storedTextContent
     * @param storedId
     * @param storedTagName
     * @param storedLocation
     * @param storedSrc
     * @param storedAlt
     * @param storedHref
     * @param storedName,
     * @parm storedType
     */
    public static WebElement getClosestElement(EventFiringWebDriver eventFiringWebDriver, String locator, String storedClassName,
                                               String storedTextContent, String storedId, String storedTagName, String storedLocation,
                                               String storedSrc, String storedAlt, String storedHref, String storedName, String storedType) {

        int closestScore = 0; // initialize closestScore
        List<WebElement> closestElements = new ArrayList<>(); // Create closest elements list if score is equal
        WebElement closestElement = null;        // Set the closest element to null

        // Search all page elements
        List<WebElement> elements = eventFiringWebDriver.findElements(By.xpath("//*"));
        for (WebElement element : elements) {  // Start matching evaluation

            int matchScore = 0;  // initialize matchScore

//            validPattern = "^" + storedClassName;  // className a bit tricky prepare the TagMatcher
//            pattern = Pattern.compile(validPattern);
//            tagMatcher = pattern.matcher(element.getAttribute("className"));
//
//            if (tagMatcher.matches()) {
//                matchScore += 1;
//            }
            // Step through each attribute determine match score
            List<String> attributes = new ArrayList<>(Arrays.asList("type", "alt", "name", "textContent", "id", "tagName", "href"));
            for (String attribute : attributes) {
                if (element.getAttribute(attribute) != null) {  // skip over null values to prevent errors
                    if ((attribute.equals("name") && element.getAttribute(attribute).equalsIgnoreCase(storedName))
                            || (attribute.equals("name") && element.getAttribute(attribute).toLowerCase().contains(storedName.toLowerCase()))
                            || (attribute.equals("name") && storedName.toLowerCase().contains(element.getAttribute(attribute).toLowerCase()))) {
                        matchScore += 1;
                    } else if (attribute.equals("alt") && element.getAttribute(attribute).equalsIgnoreCase(storedAlt)) {
                        matchScore += 1;
                    } else if (attribute.equals("src") && element.getAttribute(attribute).contains(storedSrc)) {
                        matchScore += 1;
                    } else if (attribute.equals("type") && element.getAttribute(attribute).equalsIgnoreCase(storedType)) {
                        matchScore += 1;
                    } else if ((attribute.equals("textContent") && element.getAttribute(attribute).equalsIgnoreCase(storedTextContent))
                            || (attribute.equals("textContent") && element.getAttribute(attribute).toLowerCase().contains(storedTextContent.toLowerCase()))
                            || (attribute.equals("textContent") && storedTextContent.toLowerCase().contains(element.getAttribute(attribute).toLowerCase()))) {
                        matchScore += 1;
                    } else if ((attribute.equals("id") && element.getAttribute(attribute).equals(storedId))
                            || (attribute.equals("id") && element.getAttribute(attribute).toLowerCase().contains(storedId.toLowerCase()))
                            || (attribute.equals("id") && storedId.toLowerCase().contains(element.getAttribute(attribute).toLowerCase()))) {
                        matchScore += 1;
                    } else if (attribute.equals("tagName") && element.getAttribute(attribute).equals(storedTagName)) {
                        matchScore += 1;
                    } else if (attribute.equals("href") && element.getAttribute(attribute).equals(storedHref)) {
                        matchScore += 1;
                    }
                }

            }

            // Add elements to list to count the closest element by distance if elements matchScore is equal
            if (matchScore > closestScore) {
                closestElements.clear();
                closestElement = element;
                closestScore = matchScore;
                closestElements.add(closestElement);
            } else if (matchScore == closestScore) {
                closestElement = element;
                closestElements.add(closestElement);
            }

        }

        // Select element from list of elements by min distance
        double closestDistance = Double.MAX_VALUE;

        for (WebElement ele : closestElements) {
            double distance = calculateDistance(ele, storedLocation);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestElement = ele;
            }
        }

        // No matches found / or found
        if (closestElement != null) {
            printElementDetails(closestElement, locator, closestScore);
        } else {
            logger.info("Target element not found.  Unable to provide suggestion to fix.");
        }
        // Print out possible locators to use ** this needs work only tested this thoroughly with Jsoup (but that format is way different)
        return findClosestElement(eventFiringWebDriver, closestElement);
    }

    /**
     * This method calculatesDistance from the known stored location
     *
     * @param element
     * @parm storedLocation
     */
    public static double calculateDistance(WebElement element, String storedLocation) {
        double distance = 0;
        Point currentElementLocation = element.getLocation();
        String[] pointValues = storedLocation.replace("(", "").replace(")", "").split(",");
//        for (int i = 0; i < pointValues.length; i++) {
//            System.out.println("pointValues: " + i + " " + pointValues[i]);
//        }
        if (pointValues.length > 1 && isNumeric(pointValues[0].trim()) && isNumeric(pointValues[1].trim())) {
            int x = Integer.parseInt(pointValues[0].trim());
            int y = Integer.parseInt(pointValues[1].trim());
            Point previousElementLocation = new Point(x, y);

            int xDiff = currentElementLocation.x - previousElementLocation.x;
            int yDiff = currentElementLocation.y - previousElementLocation.y;
            distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        }
        return distance;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method return possible alternate element.
     *
     * @param closestElement
     */
    private static WebElement findClosestElement(EventFiringWebDriver driver, WebElement closestElement) {
        logger.info("Some WebElement Locators to try 'By.xpath' :");
        WebElement element = null;
        if (closestElement.getAttribute("id") != null && !closestElement.getAttribute("id").isEmpty()) {
            altXpathId = "//*[@id='" + closestElement.getAttribute("id") + "']";
            By by = By.xpath(altXpathId);
            if (SeleniumBaseClass.isExists(driver, by, 1) && driver.findElement(by).isDisplayed()) {
                element = driver.findElement(by);
                logger.info("Found alternative element by xpath: " + altXpathId);
            }
        } else if (closestElement.getAttribute("name") != null && !closestElement.getAttribute("name").isEmpty()) {
            altXpathName = "//*[@name='" + closestElement.getAttribute("name") + "']";
            By by = By.xpath(altXpathName);
            if (SeleniumBaseClass.isExists(driver, by, 1) && driver.findElement(by).isDisplayed()) {
                element = driver.findElement(by);
                logger.info("Found alternative element by xpath: " + altXpathName);
            }
        } else if (closestElement.getAttribute("className") != null && !closestElement.getAttribute("className").isEmpty()) {
            altXpathClass = "//*[@class='" + closestElement.getAttribute("className") + "']";
            By by = By.xpath(altXpathClass);
            if (SeleniumBaseClass.isExists(driver, by, 1) && driver.findElement(by).isDisplayed()) {
                element = driver.findElement(by);
                logger.info("Found alternative element by xpath: " + altXpathClass);
            }
        } else if (closestElement.getAttribute("textContent") != null && !closestElement.getAttribute("textContent").isEmpty()) {
            altXpathText = "//*[text()='" + closestElement.getAttribute("textContent") + "']";
            By by = By.xpath(altXpathText);
            if (SeleniumBaseClass.isExists(driver, by, 1) && driver.findElement(by).isDisplayed()) {
                element = driver.findElement(by);
                logger.info("Found alternative element by xpath: " + altXpathText);
            }
        }
        return element;
    }

    public static String getAltXpathId() {
        return altXpathId;
    }

    /**
     * This method prints the Element Details for the element; best matched.
     *
     * @param findByContext
     * @param closestScore
     */
    public static void printElementDetails(WebElement closestElement, String findByContext, double closestScore) {
        System.out.println("Found Best Match: Match Score is " + closestScore);
        System.out.println("" + findByContext + ": {");
        System.out.println("    \"" + "tagName\": \"" + closestElement.getAttribute("tagName") + "\"");
        System.out.println("    \"" + "className\": \"" + closestElement.getAttribute("className") + "\",");
        System.out.println("    \"" + "textContent\": \"" + closestElement.getAttribute("textContent") + "\",");
        System.out.println("    \"" + "location\": \"" + closestElement.getLocation() + "\",");
        System.out.println("    \"" + "id\": \"" + closestElement.getAttribute("id") + "\",");
        System.out.println("    \"" + "name\": \"" + closestElement.getAttribute("name") + "\",");
        System.out.println("    \"" + "src\": \"" + closestElement.getAttribute("src") + "\",");
        System.out.println("    \"" + "alt\": \"" + closestElement.getAttribute("alt") + "\",");
        System.out.println("    \"" + "href\": \"" + closestElement.getAttribute("href") + "\"");
        System.out.println("}");
        logger.info("Found Best Match: Match Score is " + closestScore);
        logger.info("Tag Name : " + closestElement.getAttribute("tagName"));
        logger.info("id : " + closestElement.getAttribute("id"));
    }
}