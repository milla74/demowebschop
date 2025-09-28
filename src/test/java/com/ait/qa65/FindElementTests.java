package com.ait.qa65;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        // Найти h1 и вывести текст
        WebElement h1 = driver.findElement(By.tagName("h1"));
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        // Найти первый <a> и вывести текст
        WebElement firstLink = driver.findElement(By.tagName("a"));
        // System.out.println(element1.getText());
        System.out.println(element.getText());

        // Найти все ссылки на странице и вывести их количество
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // System.out.println(elements.size());

    }

    @Test
    public void sampleElementBySimpleLocators() {
        // По тексту ссылки (linkText / partialLinkText)
        driver.findElement(By.partialLinkText("Register"));
        driver.findElement(By.linkText("Forgot password"));
        // Если на странице есть id полей (обычно в nopCommerce используются id Email/Password)
        driver.findElement(By.id("Email"));
        driver.findElements(By.id("Password"));

    }

    @Test
    public void findElementByCssSelectorTest() {
        // По тегу через css
        driver.findElement(By.cssSelector("h1"));

        // По id через css (#)
        driver.findElement(By.cssSelector("#Email"));         // input с id="Email"
        driver.findElement(By.cssSelector("#Password"));      // input с id="Password"

        // По имени атрибута
        driver.findElement(By.cssSelector("input[name='Email']"));
        // contains (частичное совпадение атрибута)
        driver.findElement(By.cssSelector("a[href*='register']"));

    }

    @Test
    public void findElementByXpath() {
        // самый простой: тег
        driver.findElement(By.xpath("//h1"));

        // По атрибуту id (универсально)
        driver.findElement(By.xpath("//*[@id='Email']"));
        driver.findElement(By.xpath("//*[@id='Password']"));

        // По тексту ссылки
        driver.findElement(By.xpath("//a[text()='Forgot password?']"));

        // По лейблу и соседнему input (если label есть)
        // пример: //label[text()='Email:']/following::input[1]
        driver.findElement(By.xpath("//label[contains(.,'Email')]/following::input[1]"));

        // Примеры продвинутых выражений
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//a[contains(.,'Register')]/@href")); // пример получения атрибута (в коде будет getAttribute)
    }
}