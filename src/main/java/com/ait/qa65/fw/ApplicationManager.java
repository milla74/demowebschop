package com.ait.qa65.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;

    private UserHelper userHelper;
    private CartHelper cartHelper;
    private HomeHelper homeHelper;  // Было UserHelper, должно быть HomeHelper

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        // инициализация хелперов
        userHelper = new UserHelper(driver);
        cartHelper = new CartHelper(driver);
        homeHelper = new HomeHelper(driver);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    // геттеры для тестов
    public UserHelper getUser() {
        return userHelper;
    }

    public CartHelper getCart() {
        return cartHelper;
    }

    public HomeHelper getHome() {
        return homeHelper;
    }
}

