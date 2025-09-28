package com.ait.qa65.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public boolean isRegistrationSuccessful() {
        return isElementPresent(By.xpath("//div[@class='result' and contains(text(), 'Your registration completed')]"));
    }


    public void clickOnRegisterLink() {
        click(By.cssSelector("a.ico-register"));
    }

    public void fillRegistrationForm(String gender, String firstName, String lastName, String email, String password) {
        if (gender.equalsIgnoreCase("male")) {
            click(By.id("gender-male"));
        } else {
            click(By.id("gender-female"));
        }
        type(By.id("FirstName"), firstName);
        type(By.id("LastName"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("a.account"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("a.ico-login"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a.ico-login"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input.button-1.login-button"));
    }

    // --- Добавляем для CreateAccountTests ---
    public void clickOnSignOutButton() {
        click(By.cssSelector("a.ico-logout"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.cssSelector("a.ico-logout"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector("div.validation-summary-errors"));
    }
}
