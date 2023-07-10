package com.example.opencart;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


// page_url = https://awesomeqa.com/ui/index.php?route=account/register
public class RegisterTest {
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver", "/D:/Programing/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");

        RegisterPage registerPage = new RegisterPage();
        //fill form and submit
        registerPage.registerAccount(driver);

        //wait for page
        registerPage.confirmMessageWait(driver);

        //check for account creation message
        String message = "Your Account Has Been Created!";
        assertEquals(message, registerPage.getConfirmMessage(driver));

        driver.quit();
    }

}
