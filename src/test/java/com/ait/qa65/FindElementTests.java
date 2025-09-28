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
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByTagName() {
        // На главной странице используем div вместо h1
        WebElement firstDiv = driver.findElement(By.tagName("div"));
        System.out.println("First div class: " + firstDiv.getAttribute("class"));

        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("First link text: " + firstLink.getText());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());
    }

    @Test
    public void sampleElementBySimpleLocators() {
        // Правильные локаторы для демо сайта
        driver.findElement(By.partialLinkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.id("small-searchterms")); // Поле поиска
        driver.findElement(By.id("newsletter-email"));  // Поле email для рассылки
    }

    @Test
    public void findElementByCssSelectorTest() {
        // Используем реальные элементы с сайта
        driver.findElement(By.cssSelector("div.header"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("#newsletter-email"));
        driver.findElement(By.cssSelector("input[name='q']"));
        driver.findElement(By.cssSelector("a[href*='register']"));
        driver.findElement(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));
    }

    @Test
    public void findElementByXpath() {
        // Реальные элементы с главной страницы
        driver.findElement(By.xpath("//div[@class='header']"));
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        driver.findElement(By.xpath("//*[@id='newsletter-email']"));
        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Log in']"));
        driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']"));
        driver.findElement(By.xpath("//div[contains(@class, 'header-menu')]"));
    }
}
