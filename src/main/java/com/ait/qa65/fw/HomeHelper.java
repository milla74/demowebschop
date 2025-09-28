package com.ait.qa65.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeHelper extends BaseHelper {

    public HomeHelper(WebDriver driver) {
        super(driver);
    }

    // Открыть раздел Books
    public void openBooksPage() {
        click(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]"));
    }

    // Проверить, открыта ли страница Books
    public boolean isBooksPageOpened() {
        return isElementPresent(By.xpath("//h1[text()='Books']"));
    }

    // Получить заголовок страницы
    public String getPageTitle() {
        return driver.getTitle();
    }
}