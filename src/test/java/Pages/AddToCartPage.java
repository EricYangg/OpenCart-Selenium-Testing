package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AddToCartPage {
    public static void AddItem(WebDriver driver){
        //Adds MacBook and iPhone to Cart
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(1) > div > div:nth-of-type(3) > button:nth-of-type(1)")).click();
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > button:nth-of-type(1) > i")).click();
    }
    public static void fileUpload(WebDriver driver) throws AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //file upload
        driver.findElement(By.cssSelector("button[id='button-upload222']")).click();
        // Provide the file path to upload using the system's native file chooser dialog
        String filePath = "D:\\Programming Aqua\\OpenCart\\src\\test\\java\\Pages\\Test.txt";
        StringSelection fileSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelection, null);
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            // Wait for alert to appear
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            // Close alert
            alert.accept();
        } catch (TimeoutException e) {
            // Handle the timeout exception
            System.out.println("Alert did not appear within the specified timeout.");
        } finally {
            // Switch the driver's focus back to the main window
            driver.switchTo().defaultContent();
        }
    }
    public static void AddAppleCinema(WebDriver driver) throws AWTException {
        RandomStringGenerator randomString = new RandomStringGenerator();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //redirected when adding to cart
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(3) > button:nth-of-type(1)")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html > body > div:nth-of-type(2) > ul > li:nth-of-type(2) > a"))));

        //fill out form
        //radio button
        driver.findElement(By.cssSelector("input[value='6']")).click();
        //checkbox
        driver.findElement(By.cssSelector("input[value='11']")).click();
        //Textbox 1
        driver.findElement(By.cssSelector("input[id='input-option208']")).clear();
        driver.findElement(By.cssSelector("input[id='input-option208']")).sendKeys(randomString.randomQuote());
        //Dropdown
        driver.findElement(By.cssSelector("select[id='input-option217']")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        //Textbox 2
        driver.findElement(By.cssSelector("textarea[id='input-option209']")).sendKeys(randomString.randomQuote());

        //upload file
        fileUpload(driver);

        //date
        driver.findElement(By.cssSelector("input[id='input-option219']")).clear();
        driver.findElement(By.cssSelector("input[id='input-option219']")).sendKeys(randomString.randomDate());
        //time
        driver.findElement(By.cssSelector("input[id='input-option221']")).clear();
        driver.findElement(By.cssSelector("input[id='input-option221']")).sendKeys(randomString.randomTime());
        //date & time
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(9) > div > span > button")).click();
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(4) > ul > li:nth-of-type(1) > div > div:nth-of-type(1) > table > tbody > tr:nth-of-type(5) > td:nth-of-type(2)"));
        driver.findElement(By.cssSelector("a[style='width:100%']")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html > body > div:nth-of-type(4) > ul > li:nth-of-type(3) > div > div:nth-of-type(1) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > a"))));
        driver.findElement(By.cssSelector("html > body > div:nth-of-type(4) > ul > li:nth-of-type(3) > div > div:nth-of-type(1) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > a")).click();
        driver.findElement(By.cssSelector("button[id='button-cart']")).click();

        //wait for item to be successfully added
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='alert-success']"))));
        driver.findElement(By.cssSelector("a[title^='Shopping'] i[class$='fa-shopping-cart']")).click();

    }
}
