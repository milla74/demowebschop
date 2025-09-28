package com.ait.qa65;

import com.ait.qa65.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}

