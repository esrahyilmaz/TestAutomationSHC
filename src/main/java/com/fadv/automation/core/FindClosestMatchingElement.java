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
    public static void findClosestMatch(EventFiringWebDriver eventFiringWebDriver, String _findByContext, String storedClassName,
                                        String storedTextContent, String storedId, String storedTagName, String storedLocation,
                                        String storedSrc, String storedAlt, String storedHref, String storedName, String storedType) {
        double closestScore = 0; // initialize closestScore
        List<WebElement> elements = eventFiringWebDriver.findElements(By.xpath("//*"));  // Search all page elements
        WebElement closestElement = elements.get(0);        // Set the closest element to the first element in the list

        for (WebElement element : elements) {  // Start matching evaluation
            double matchScore = 0;  // initialize matchScore

            validPattern = "^" + storedClassName;  // className a bit tricky prepare the TagMatcher
            pattern = Pattern.compile(validPattern);
            tagMatcher = pattern.matcher(element.getAttribute("className"));

            List<String> attributes = new ArrayList<>(Arrays.asList("type", "alt", "name", "textContent", "id", "tagName", "href"));  // Step through each attribute determine match score
            for (String attribute : attributes) {
                if (!(element.getAttribute(attribute) == null)) {  // skip over null values to prevent errors
                    if (attribute.equals("name") && element.getAttribute(attribute).equalsIgnoreCase(storedName)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("alt") && element.getAttribute(attribute).equalsIgnoreCase(storedAlt)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("src") && element.getAttribute(attribute).contains(storedSrc)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("type") && element.getAttribute(attribute).equalsIgnoreCase(storedType)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("textContent") && element.getAttribute(attribute).equalsIgnoreCase(storedTextContent)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("id") && element.getAttribute(attribute).equals(storedId)) {
                        matchScore += 0.25;
                    } else if (tagMatcher.matches()) {
                        matchScore += 0.25;
                    } else if (attribute.equals("tagName") && element.getAttribute(attribute).equals(storedTagName)) {
                        matchScore += 0.25;
                    } else if (attribute.equals("href") && element.getAttribute(attribute).equals(storedHref)) {
                        matchScore += 0.25;
                    }
                }
            }

            if (matchScore > 0) {  // Calculate distance from known stored location.  This has been tricky.  Keep it low .10 (false positives)
                double distance = calculateDistance(element, storedLocation);
                if (distance < 50) {
                    matchScore += 0.1;
                }
            }

            closestElement = (matchScore > closestScore) ? element : closestElement;   //ChatGPT help here (This method rather long so trying to save some space.
            closestScore = (matchScore > closestScore) ? matchScore : closestScore;

        }
        if (closestScore != 0.0) {  // No matches found / or found
            printElementDetails(closestElement, _findByContext, closestScore);
        } else {
            System.out.println(">> Target Element NOT Found.  Unable to provide suggestion to fix.");
        }

        printLocators(closestElement);  // Print out possible locators to use ** this needs work only tested this thoroughly with Jsoup (but that format is way different)

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
     * This method prints possible alternate locators to try.
     *
     * @param closestElement
     */
    public static void printLocators(WebElement closestElement) {
        logger.info("Some WebElement Locators to try 'By.xpath' :");
        if (closestElement.getAttribute("id") != null) {
            altXpathId = "//*[@id='" + closestElement.getAttribute("id") + "']";
            logger.info("altXpathId: " + altXpathId);
        }
        if (closestElement.getAttribute("name") != null) {
            altXpathName = "//*[@name='" + closestElement.getAttribute("name") + "']";
            logger.info("altXpathName: " + altXpathName);
        }
        if (closestElement.getAttribute("className") != null) {
            altXpathClass = "//*[@class='" + closestElement.getAttribute("className") + "']";
            logger.info("altXpathClass: " + altXpathClass);
        }
        if (closestElement.getAttribute("textContent") != null) {
            altXpathText = "//*[text()='" + closestElement.getAttribute("textContent") + "']";
            logger.info("altXpathText: " + altXpathText);
        }
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