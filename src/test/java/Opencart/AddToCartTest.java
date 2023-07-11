package Opencart;

import Pages.AddToCartPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

// page_url = https://awesomeqa.com/ui/index.php?route=common/home
public class AddToCartTest {

    public static void main(String[] args) throws AWTException, InterruptedException {
        //chromedriver path
        String path="your_path/folder/chromedriver.exe";

        // Create ExtentReports object and HTML report file
        ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("AddToCart Report.html");
        extent.attachReporter(htmlReporter);

        // Create ExtentTest object for the test
        ExtentTest test = extent.createTest("Add Items To Cart Test", "This test is to test the functions of the add to cart button, as well as filling out the form required to add certain items");

        // Create an instance of LoggingUtils
        LoggingUtils logger = new LoggingUtils(test);

        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

        AddToCartPage addToCart = new AddToCartPage(driver);

        addToCart.AddItem(driver, logger);

        addToCart.AddAppleCinema(driver, logger);

        // End the test and mark it as complete
        extent.flush();
        //close WebDriver Instance
        driver.quit();
    }
}
