package com.tftus.seleniumshooter.shooters;

import com.tftus.seleniumshooter.Snapshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by kumar.nipun on 13/08/18
 */
public abstract class Shooter {

    protected abstract Snapshot capture(WebDriver driver);
}
