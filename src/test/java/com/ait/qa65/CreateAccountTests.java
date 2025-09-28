package com.ait.qa65;

import com.ait.qa65.data.UserData;
import com.ait.qa65.utils.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        // Генерируем полностью случайные данные
        String randomEmail = Data.generateRandomEmail();
        String randomFirstName = Data.generateRandomFirstName();
        String randomLastName = Data.generateRandomLastName();

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegistrationForm(
                UserData.GENDER,
                randomFirstName,  // Используем случайное имя
                randomLastName,   // Используем случайную фамилию
                randomEmail,      // Используем случайный email
                UserData.PASSWORD
        );
        app.getUser().clickOnRegisterButton();

        // Добавим проверку успешной регистрации
        boolean isRegistered = app.getUser().isUserLoggedIn();
        if (!isRegistered) {
            // Если регистрация не удалась, проверим есть ли ошибка
            boolean hasError = app.getUser().isErrorMessagePresent();
            if (hasError) {
                System.out.println("Registration failed with error message");
            }
        }
        Assert.assertTrue(isRegistered, "User is not logged in after registration");
    }

    @Test
    public void loginWithExistingUserTest() {
        // Сначала попробуем зарегистрировать нового пользователя
        String randomEmail = Data.generateRandomEmail();

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegistrationForm(
                UserData.GENDER,
                UserData.FIRSTNAME,
                UserData.LASTNAME,
                randomEmail,
                UserData.PASSWORD
        );
        app.getUser().clickOnRegisterButton();

        // Разлогинимся
        app.getUser().clickOnSignOutButton();

        // Теперь пробуем логин с только что созданными данными
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(randomEmail, UserData.PASSWORD);
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isUserLoggedIn(), "User is not logged in");
    }
}


