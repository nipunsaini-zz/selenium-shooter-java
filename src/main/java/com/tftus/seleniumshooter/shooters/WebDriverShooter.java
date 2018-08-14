package com.tftus.seleniumshooter.shooters;

import com.tftus.seleniumshooter.shooters.Shooter;
import org.openqa.selenium.WebDriver;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class WebDriverShooter extends Shooter {

    public WebDriverShooter(WebDriver driver) {
        super(driver);
    }
}
