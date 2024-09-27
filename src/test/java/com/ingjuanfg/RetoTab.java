package com.ingjuanfg;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;


public class RetoTab {
    public static WebDriver driver;

    @BeforeAll
    public static void configuracionInicial() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    //Reto Tab{
    public void testTabInteraction() {
        //ARRANCE
        driver.get("https://automationtesting.co.uk/browserTabs.html");
        //ACT

        WebElement openTabButton = driver.findElement(By.xpath("//div[@class='col-4 col-12-medium']//input[@value='Open Tab']"));
        openTabButton.click();
        String originalWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        while (allWindows.size() == 1) {
            allWindows = driver.getWindowHandles();
        }

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement searchInput = driver.findElement(By.xpath("//div[@id='searchform']//input[@name='q']"));
        searchInput.sendKeys("google" + Keys.ENTER);
    }
    @AfterAll
    public static void configuracionFinal() {
        //driver.quit();
    }
}