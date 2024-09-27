package com.ingjuanfg;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreateUserTest_Reto1 {
    public static WebDriver driver;

    @BeforeAll
    public static void configuracionInicial(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
//Reto 1
    @Test
    public void testCreateUserExitoso() {
        //ARRANCE
        driver.get("https://teststore.automationtesting.co.uk/index.php/");
        //ACT
        WebElement buttonLogin = driver.findElement(By.id(("_desktop_user_info")));
        buttonLogin.click();
        WebElement buttonCreateUser = driver.findElement(By.xpath("//div[contains(@class, 'no-account')]//a"));
        buttonCreateUser.click();
        //Formulario de registro
        String firstName = "Juan Camilo Castro -";
        String lastName = " Anderson Olarte";
        String email = "jccastro111871111@eafit.edu.com";
        String password = "fdvjksfñjwadoi";
        String birthDate = "03/01/1998";

        //
        WebElement SocialTitle = driver.findElement(By.xpath("//span[contains(@class, 'custom-radio')]//input[@id='field-id_gender-1']"));
        SocialTitle.click();
        //
        WebElement FirstName = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@id='field-firstname']"));
        WebElement LastName = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@id='field-lastname']"));
        WebElement Email = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@id='field-email']"));
        WebElement Password = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@id='field-password']"));
        WebElement BirthDate = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@id='field-birthday']"));
        WebElement ReceivePartners = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@name='optin']"));
        WebElement IAgreePolicy = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@name='psgdpr']"));
        WebElement SingUp = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//input[@name='newsletter']"));
        WebElement SaveButton = driver.findElement(By.xpath("//form[contains(@class, 'js-customer-form')]//button[@data-link-action='save-customer']"));
        //
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        Email.sendKeys(email);
        Password.sendKeys(password);
        BirthDate.sendKeys(birthDate);
        ReceivePartners.click();
        IAgreePolicy.click();
        SingUp.click();
        SaveButton.click();
        //ASSERT
        WebElement AccountName = driver.findElement(By.xpath("//A[contains(@class, 'account')]//span"));
        assertEquals(firstName + " " + lastName, AccountName.getText());

        //LogOut
        WebElement ButtonSingOut = driver.findElement(By.xpath("//div[contains(@class, 'user-info')]//a"));
        ButtonSingOut.click();
    }

    private void assertEquals(String s, String text) {
    }
    @AfterAll
    public static void configuracionFinal(){
        driver.quit();
    }
}
