package com.ait.qa65.utils;

import java.util.Random;

public class Data {

    // Генерация случайного email
    public static String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@mail.com";
    }

    // Генерация случайного пароля
    public static String generateRandomPassword() {
        return "Pass" + new Random().nextInt(10000) + "!";
    }

    // Генерация случайного имени
    public static String generateRandomFirstName() {
        String[] names = {"John", "Jane", "Mike", "Sarah", "David", "Emma"};
        return names[new Random().nextInt(names.length)];
    }

    // Генерация случайной фамилии
    public static String generateRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Brown", "Wilson", "Taylor", "Davis"};
        return lastNames[new Random().nextInt(lastNames.length)];
    }
}