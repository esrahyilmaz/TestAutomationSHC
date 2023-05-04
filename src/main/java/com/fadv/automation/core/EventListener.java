package com.fadv.automation.core;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener implements WebDriverEventListener {
    WebElementHelper helper = new WebElementHelper();
    FindClosestMatchingElement objectSearch = new FindClosestMatchingElement();

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        // Code to execute before navigating to a URL goes here
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        // Code to execute after navigating to a URL goes here
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Reviewing the following 'findBy' element: " + by);
        helper.addByPropertiesToMap(driver, by);

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
//        String inputString = throwable.getLocalizedMessage();
//        String findByContext = "";
//        String findByType = null;
//        String element = null;
//        System.out.println("Error Message: " + inputString);
//        String pattern = "findElement \\{using=(.*?), value=[a-z]+\\}";
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(inputString);
//        if (m.find()) {
//            String input = m.group();
//            customLogError(input);
//            String[] parts = input.split(",");
//
//            findByType = parts[0].split("=")[1];
//            element = parts[1].split("=")[1].replace("}", "");
//
//            //Hate to do it this way but good for now, in a hurry
//            if (findByType.contains("tag name")) {
//                findByType = "tagName";
//            }
//            System.out.println("id: " + findByType);
//            System.out.println("heading: " + element);
//            findByContext = "By." + findByType + ": " + element;
//        }
//        if (findByContext.isEmpty()) {
//            // Extract the XPath expression
//            pattern = "(//li\\[contains\\(text\\(\\),')(.*?)('\\)\\])";
//            p = Pattern.compile(pattern);
//            m = p.matcher(inputString);
//
//            String xpath = "";
//            String text = "";
//
//            if (m.find()) {
//                String input = m.group();
//                System.out.println("Input:" + input);
//                findByType = m.group(1) + m.group(2) + m.group(3);
//                element = m.group(2);
//                findByContext = "By.xpath: " + input;
//
//            }
//        }
//        if (!findByContext.isEmpty()) {
//            helper.retrieveMapValuesByKey(findByContext);
//            System.out.println("Element Not Found:");
//            System.out.println(findByContext + ": {");
//            System.out.println("    \"" + "className\": \"" + helper.getClassName() + "\",");
//            System.out.println("    \"" + "textContent\": \"" + helper.getTextContent() + "\",");
//            System.out.println("    \"" + "location\": \"" + helper.getLocation() + "\",");
//            System.out.println("    \"" + "id\": \"" + helper.getId() + "\",");
//            System.out.println("    \"" + "tagName\": \"" + helper.getTagName() + "\"");
//            System.out.println("    \"" + "alt\": \"" + helper.getAlt() + "\"");
//            System.out.println("    \"" + "src\": \"" + helper.getSrc() + "\"");
//            System.out.println("    \"" + "href\": \"" + helper.getHref() + "\"");
//            System.out.println("    \"" + "name\": \"" + helper.getName() + "\"");
//            System.out.println("    \"" + "keyValue\": \"" + helper.getRandomKey() + "\"");
//            System.out.println("}\n");
//            //Need a method to read from stored map and retrieve key value prperties
//
//            // System.out.println("Location:"+helper.getLocation());
//            objectSearch.FindClosestMatch(findByContext, getClassName(), getTextContent(), getId(), getTagName(), getLocation(), getSrc(), getAlt(), getHref(), getName(), getType());
//        } else {
//            System.out.println(">>> Previous mapping not found in myPageElements.json file. <<<");
//        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }

    // Other methods go here
}