package com.ait.qa65.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    // Добавить книгу в корзину по названию
    public void addBookToCart(String bookName) {
        click(By.xpath("//h2[@class='product-title']/a[text()='" + bookName + "']/../../..//input[@value='Add to cart']"));
    }

    // Перейти в корзину
    public void openCart() {
        click(By.cssSelector("a.ico-cart"));
    }

    // Проверка, есть ли товар в корзине
    public boolean isBookInCart(String bookName) {
        return isElementPresent(By.xpath("//td[@class='product']/a[text()='" + bookName + "']"));
    }

    // Удалить книгу из корзины
    public void removeBookFromCart(String bookName) {
        // снимаем галочку "Remove" у товара
        click(By.xpath("//td[@class='product']/a[text()='" + bookName + "']/../../td[@class='remove-from-cart']/input"));
        // нажимаем кнопку обновления корзины
        click(By.name("updatecart"));
    }
}