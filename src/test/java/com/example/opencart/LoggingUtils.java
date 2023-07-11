package com.example.opencart;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

public class LoggingUtils {
    private ExtentTest test;

    public LoggingUtils(ExtentTest test) {
        this.test = test;
    }

    public void logStep(Status status, String stepDescription) {
        if (status == Status.PASS) {
            test.pass(stepDescription);
        } else if (status == Status.FAIL) {
            test.fail(stepDescription);
        } else {
            test.info(stepDescription);
        }
    }

    public void logSendKeys(WebElement element, String text) {
        logSendKeys(element, text, true);
    }

    public void logSendKeys(WebElement element, String text, boolean successful) {
        String logMessage = String.format("Entering value '%s' into element '%s'", text, element);
        if (successful) {
            logStep(Status.PASS, logMessage);
        } else {
            logStep(Status.FAIL, logMessage);
        }
    }

    public void logClick(WebElement element) {
        logClick(element, true);
    }

    public void logClick(WebElement element, boolean successful) {
        String logMessage = String.format("Clicking on element '%s'", element);
        if (successful) {
            logStep(Status.PASS, logMessage);
        } else {
            logStep(Status.FAIL, logMessage);
        }
    }
}
