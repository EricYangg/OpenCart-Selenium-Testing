package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public static void registerAccount(WebDriver driver){
        //form variables
        RandomStringGenerator randomString = new RandomStringGenerator();
        String firstName = RandomStringGenerator.randomFirstName();
        String lastName = RandomStringGenerator.randomLastName();
        String email = RandomStringGenerator.randomEmail();
        String phone = RandomStringGenerator.randomPhone();
        String password = RandomStringGenerator.randomPassword();

        driver.findElement(By.cssSelector("input[id='input-firstname']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[id='input-lastname']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[id='input-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[id='input-telephone']")).sendKeys(phone);
        driver.findElement(By.cssSelector("input[id='input-password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='input-confirm']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name='agree']")).click();
        driver.findElement(By.cssSelector("input[class$='btn-primary']")).click();

    }

    public static void confirmMessageWait(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))));
    }
    public static String getConfirmMessage(WebDriver driver){
        return driver.findElement(By.cssSelector("h1")).getText();
    }
}
