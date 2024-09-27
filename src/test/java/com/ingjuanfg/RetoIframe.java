package com.talleres;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RetoIframe {
    public static WebDriver driver;

    @BeforeAll
    public static void configuracionInicial() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    //Reto Iframe
    public void testIframeInteraction() {
        //ARRANCE
        driver.get("https://automationtesting.co.uk/iframes.html");
        //ACT
        // Cambio Iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='index.html']"));
        driver.switchTo().frame(iframe);

        //
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement Toggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sidebar']//a[@class='toggle']")));
        Toggle.click();

        //
        WebElement Text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sidebar']//ul/li/a[text()='Accordion']")));
        Text.click();

        // Cambiar al contenido principal
        driver.switchTo().defaultContent();

        // Scroll y clic en el toggle grande de la página principal
        WebElement bigToggle = driver.findElement(By.xpath("//div[@id='sidebar']//a[@class='toggle']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bigToggle);
        wait.until(ExpectedConditions.elementToBeClickable(bigToggle)).click();
    }

    @AfterAll
    public static void configuracionFinal() {
        driver.quit();
    }
}