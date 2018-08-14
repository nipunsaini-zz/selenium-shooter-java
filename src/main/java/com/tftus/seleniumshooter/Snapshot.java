package com.tftus.seleniumshooter;

import java.awt.image.BufferedImage;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class Snapshot {

    private BufferedImage snap;

    public Snapshot(BufferedImage snap) {
        this.snap = snap;
    }

    public BufferedImage getSnap() {
        return snap;
    }

    public void setSnap(BufferedImage snap) {
        this.snap = snap;
    }
}
