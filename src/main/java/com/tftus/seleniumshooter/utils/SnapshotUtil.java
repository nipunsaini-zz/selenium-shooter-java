package com.tftus.seleniumshooter.utils;

import com.tftus.seleniumshooter.Snapshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kumar.nipun on 14/08/18
 */
public class SnapshotUtil {

    private static <X> X getScreenshot(WebDriver driver, OutputType<X> type) {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        return takesScreenshot.getScreenshotAs(type);
    }

    private static File getScreenshotAsFile(WebDriver driver) {
        return getScreenshot(driver, OutputType.FILE);
    }

    public static String getScreenshotAsBase64(WebDriver driver) {
        return getScreenshot(driver, OutputType.BASE64);
    }

    public static Snapshot getSnapshot(WebDriver driver) {
        try {
            BufferedImage image = ImageIO.read(getScreenshotAsFile(driver));
            return new Snapshot(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
