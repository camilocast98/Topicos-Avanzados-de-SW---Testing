package com.ingjuanfg;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static WebDriver driver;

    @BeforeAll
    public static void configuracionInicial(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testloginExitoso() {
        //ARRANCE
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\OneDrive\\Escritorio\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        //ACT
        WebElement inputUser = driver.findElement(By.id(("user-name")));
        WebElement inputPassword = driver.findElement(By.id(("password")));
        WebElement buttonLogin = driver.findElement(By.id(("login-button")));

        inputUser.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        buttonLogin.click();
        //ASSERT
        WebElement pageTitle = driver.findElement(By.xpath("//span[@data-test='title']"));


    }
        @AfterAll
        public static void configuracionFinal(){
            driver.quit();
        }
    }

