package com.tftus.seleniumshooter.shooters;

import org.openqa.selenium.WebDriver;

/**
 * Created by kumar.nipun on 13/08/18
 */
public abstract class Shooter {

    private WebDriver driver;

    public Shooter(WebDriver driver) {
        this.driver = driver;
    }
}
