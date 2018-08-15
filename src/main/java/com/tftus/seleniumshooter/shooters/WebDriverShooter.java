package com.tftus.seleniumshooter.shooters;

import com.tftus.seleniumshooter.Snapshot;
import com.tftus.seleniumshooter.shooters.Shooter;
import com.tftus.seleniumshooter.utils.SnapshotUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class WebDriverShooter extends Shooter {

    @Override
    protected Snapshot capture(WebDriver driver) {
        return SnapshotUtil.getSnapshot(driver);
    }
}
