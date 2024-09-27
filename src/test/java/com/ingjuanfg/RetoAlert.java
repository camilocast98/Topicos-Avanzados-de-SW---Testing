package com.ingjuanfg;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;



public class RetoAlert {
    public static WebDriver driver;

    @BeforeAll
    public static void configuracionInicial() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    //Reto Iframe
    public void testAlertInteraction() {
        //ARRANCE
        driver.get("https://automationtesting.co.uk/popups.html");
        //ACT

        WebElement buttonTrigger = driver.findElement(By.xpath("//div[@class='row']//button[text()='Trigger Alert']"));

        buttonTrigger.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @AfterAll
    public static void configuracionFinal() {
        driver.quit();
    }

}