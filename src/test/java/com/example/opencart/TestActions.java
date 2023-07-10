package com.example.opencart;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

public class TestActions {
    private ExtentTest test;

    public void LoggingUtils(ExtentTest test) {
        this.test = test;
    }

    public void logStep(Status status, String stepDescription) {
        test.log(status, stepDescription);
    }

    public void logSendKeys(WebElement element, String text) {
        String logMessage = String.format("Entering value '%s' into element '%s'", text, element);
        logStep(Status.INFO, logMessage);
        element.sendKeys(text);
    }

    public void logClick(WebElement element) {
        String logMessage = String.format("Clicking on element '%s'", element);
        logStep(Status.INFO, logMessage);
        element.click();
    }
}