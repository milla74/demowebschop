package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteFromCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // Логинимся
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm("Millas@gmail.com","Milla1234!");
        app.getUser().clickOnLoginButton();

        // Добавим книгу в корзину для удаления
        app.getHome().openBooksPage();
        app.getCart().addBookToCart("Computing and Internet");
        app.getCart().openCart();
        Assert.assertTrue(app.getCart().isBookInCart("Computing and Internet"), "Книга не добавлена в корзину");
    }

    @Test
    public void deleteBookFromCartTest() {
        app.getCart().removeBookFromCart("Computing and Internet");
        Assert.assertFalse(app.getCart().isBookInCart("Computing and Internet"), "Книга не удалена из корзины");
    }
}