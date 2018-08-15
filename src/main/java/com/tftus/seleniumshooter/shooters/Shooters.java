package com.tftus.seleniumshooter.shooters;


/**
 * Created by kumar.nipun on 13/08/18
 */
public final class Shooters {

    private Shooters() {
        throw new UnsupportedOperationException("This class can't be initialized");
    }

    public static Shooter defaultShooter() {
        return new WebDriverShooter();
    }

    public static Shooter scrollingShooter(int scrollTimeout) {
        return new ScrollingShooter(scrollTimeout);
    }

    public static Shooter scrollingShooterWithHeaderCut(int headerHeight, int scrollTimeout) {
        return new ScrollingShooter(headerHeight, scrollTimeout);
    }

    public static Shooter scrollingShooterWithFooterCut(int footerHeight, int scrollTimeout) {
        return new ScrollingShooter(0, footerHeight, scrollTimeout);
    }

    public static Shooter scrollingShooterWithHeaderFooterCut(int headerHeight, int footerHeight, int scrollTimeout) {
        return new ScrollingShooter(headerHeight, footerHeight, scrollTimeout);
    }
}
