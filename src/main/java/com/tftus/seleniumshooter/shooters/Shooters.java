package com.tftus.seleniumshooter.shooters;

import org.openqa.selenium.WebDriver;

/**
 * Created by kumar.nipun on 13/08/18
 */
public final class Shooters {

    private Shooters() {
        throw new UnsupportedOperationException("This class can't be initialized");
    }

    public static Shooter defaultShooter(WebDriver driver) {
        return new WebDriverShooter(driver);
    }
}
