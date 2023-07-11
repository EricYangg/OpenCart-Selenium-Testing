package Pages;

import com.aventstack.extentreports.Status;
import com.beust.ah.A;
import com.example.opencart.LoggingUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AddToCartPage {
    private WebDriver driver;

    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(1) > div > div:nth-of-type(3) > button:nth-of-type(1)")
    private  WebElement MacBookButton;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(3) > button:nth-of-type(1)")
    private WebElement iPhoneButton;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div:nth-of-type(2) > div:nth-of-type(3) > div > div:nth-of-type(3) > button:nth-of-type(1)")
    private WebElement AppleCinemaButton;
    @FindBy(css = "input[value='6']")
    private WebElement mediumRadioButton;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(4) > label")
    private WebElement checkboxButton;
    @FindBy(css = "input[id='input-option208']")
    private WebElement textBox1;
    @FindBy(css = "select[id='input-option217']")
    public WebElement dropDownSelectorButton;
    @FindBy(css = "option[value='1']")
    private WebElement dropdownButton;

    @FindBy(css = "textarea[id='input-option209']")
    private WebElement textBox2;
    @FindBy(css = "input[id='input-option219']")
    private WebElement dateBox;
    @FindBy(css = "input[id='input-option221']")
    private WebElement timeBox;
    @FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
    private WebElement addToCartButton;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(9) > div > span > button")
    private WebElement dateTimeButton;
    @FindBy(css = "html > body > div:nth-of-type(4) > ul > li:nth-of-type(1) > div > div:nth-of-type(1) > table > tbody > tr:nth-of-type(5) > td:nth-of-type(2)")
    private WebElement dateButton;
    @FindBy(css = "a[style='width:100%']")
    private WebElement changeTimeButton;
    @FindBy(css = "html > body > div:nth-of-type(4) > ul > li:nth-of-type(3) > div > div:nth-of-type(1) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > a")
    private WebElement changeTimeUpButton;
    @FindBy(css = "div[class*='alert-success']")
    private WebElement successAlert;
    @FindBy(css = "a[title^='Shopping']")
    private WebElement cartButton;
    @FindBy(css = "html > body > div:nth-of-type(2) > ul > li:nth-of-type(2) > a")
    private WebElement cinemaLink;
    @FindBy(css = "button[id='button-upload222']")
    private WebElement uploadButton;

    
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddItem(WebDriver driver, LoggingUtils logger){

        //Adds MacBook and iPhone to Cart
        logger.logStep(Status.INFO, "Add MacBook to Cart");
        boolean successfulClick = performClick(MacBookButton);
        logger.logClick(MacBookButton, successfulClick);
        
        logger.logStep(Status.INFO, "Add iPhone to Cart");
        successfulClick = performClick(iPhoneButton);
        logger.logClick(iPhoneButton, successfulClick);
    }
    public void fileUpload(WebDriver driver, LoggingUtils logger) throws AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //file upload
        uploadButton.click();
        
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
    public void AddAppleCinema(WebDriver driver, LoggingUtils logger) throws AWTException, InterruptedException {
        RandomStringGenerator randomString = new RandomStringGenerator();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Adding Apple Cinema
        logger.logStep(Status.INFO, "Add Apple Cinema to Cart");
        boolean successfulClick = performClick(AppleCinemaButton);
        logger.logClick(AppleCinemaButton, successfulClick);
        //wait for page to appear
        wait.until((ExpectedConditions.visibilityOf(cinemaLink)));

        //fill out form
        //radio button
        logger.logStep(Status.INFO, "Select Medium Radio Button");
        successfulClick = performClick(mediumRadioButton);
        logger.logClick(mediumRadioButton, successfulClick);
        //checkbox
        logger.logStep(Status.INFO, "Select Checkbox 4");
        successfulClick = performClick(checkboxButton);
        logger.logClick(checkboxButton, successfulClick);
        //Textbox 1
        textBox1.clear();
        String text = randomString.randomQuote();
        logger.logStep(Status.INFO, "Enter text in Text Box");
        boolean successfulSendKeys = performSendKeys(textBox1, text); // Some method to perform the sendKeys and return success status
        logger.logSendKeys(textBox1, text, successfulSendKeys);
        //Dropdown
        dropDownSelectorButton.click();
        logger.logStep(Status.INFO, "Select Green from Dropdown");
        successfulClick = performClick(dropdownButton);
        logger.logClick(dropdownButton, successfulClick);
        //Textbox 2
        text = randomString.randomQuote();
        logger.logStep(Status.INFO, "Enter text in Textarea Box");
        successfulSendKeys = performSendKeys(textBox2, text); // Some method to perform the sendKeys and return success status
        logger.logSendKeys(textBox2, text, successfulSendKeys);        

        //upload file
        fileUpload(driver, logger);

        //date
        dateBox.clear();
        text = randomString.randomDate();
        logger.logStep(Status.INFO, "Enter Date in Date Field");
        successfulSendKeys = performSendKeys(dateBox, text); // Some method to perform the sendKeys and return success status
        logger.logSendKeys(dateBox, text, successfulSendKeys);
        //time
        timeBox.clear();
        text = randomString.randomTime();
        logger.logStep(Status.INFO, "Enter Time in Date Field");
        successfulSendKeys = performSendKeys(timeBox, text); // Some method to perform the sendKeys and return success status
        logger.logSendKeys(timeBox, text, successfulSendKeys);
        //date & time
        dateTimeButton.click();
        dateButton.click();
        changeTimeButton.click();
        wait.until((ExpectedConditions.visibilityOf(changeTimeUpButton)));
        logger.logStep(Status.INFO, "Selected Date and Time");
        successfulClick = performClick(changeTimeUpButton);
        logger.logClick(changeTimeUpButton, successfulClick);

        logger.logStep(Status.INFO, "Click Add To Cart");
        successfulClick = performClick(addToCartButton);
        logger.logClick(addToCartButton, successfulClick);

        //wait for item to be successfully added
        wait.until((ExpectedConditions.visibilityOf(successAlert)));
        cartButton.click();

    }
    public static boolean performClick(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean performSendKeys(WebElement element, String text) {
        try {
            element.sendKeys(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

