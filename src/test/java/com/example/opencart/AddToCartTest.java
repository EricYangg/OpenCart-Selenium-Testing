package com.example.opencart;

import Pages.AddToCartPage;
import Pages.RandomStringGenerator;
import Pages.RegisterPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

// page_url = https://awesomeqa.com/ui/index.php?route=common/home
public class AddToCartTest {
    
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/D:/Programing/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

        AddToCartPage addToCart = new AddToCartPage();

        addToCart.AddItem(driver);

        addToCart.AddAppleCinema(driver);

        driver.quit();
    }
}
