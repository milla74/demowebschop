package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BooksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // Открываем главную страницу перед каждым тестом
        if (!app.getHome().isBooksPageOpened()) {
            app.getHome().openBooksPage();
        }
    }

    @Test
    public void booksPageShouldBeAccessible() {
        Assert.assertTrue(app.getHome().isBooksPageOpened(), "Books page is not opened");
    }

    @Test
    public void booksPageTitleShouldContainBooks() {
        String title = app.getHome().getPageTitle();
        Assert.assertTrue(title.toLowerCase().contains("books"), "Page title does not contain 'Books'. Actual title: " + title);
    }
}