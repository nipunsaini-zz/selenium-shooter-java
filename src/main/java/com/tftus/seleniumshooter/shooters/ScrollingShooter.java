package com.tftus.seleniumshooter.shooters;

import com.tftus.seleniumshooter.Snapshot;
import com.tftus.seleniumshooter.utils.JavascriptInjector;
import com.tftus.seleniumshooter.utils.SnapshotUtil;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.tftus.seleniumshooter.js.Scripts.*;
import static com.tftus.seleniumshooter.utils.ImageUtil.*;

/**
 * Created by kumar.nipun on 15/08/18
 */
public class ScrollingShooter extends Shooter {

    private int stickyHeaderHeight;
    private int stickyFooterHeight;
    private int scrollTimeout;

    public ScrollingShooter(int scrollTimeout) {
        this(0, 0, scrollTimeout);
    }

    public ScrollingShooter(int stickyHeaderHeight, int scrollTimeout) {
        this(stickyHeaderHeight, 0, scrollTimeout);
    }

    public ScrollingShooter(int stickyHeaderHeight, int stickyFooterHeight, int scrollTimeout) {
        this.stickyHeaderHeight = stickyHeaderHeight;
        this.stickyFooterHeight = stickyFooterHeight;
        this.scrollTimeout = scrollTimeout;
    }

    @Override
    protected Snapshot capture(WebDriver driver) {
        try {
            return new Snapshot(withHeaderCut(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedImage withHeaderCut(WebDriver driver) throws IOException {

        //scrollBottomTop();
        JavascriptInjector injector = new JavascriptInjector(driver);

        int totalheight = Integer.parseInt(injector.execute(getFullPageScript()).toString());
        int viewportHeight = Integer.parseInt(injector.execute(getViewportHeightScript()).toString());
        int width = Integer.parseInt(injector.execute(getViewportWidthScript()).toString());


        int scrolled = 0;
        int count = 1;

        BufferedImage result = new BufferedImage(width, viewportHeight, BufferedImage.TYPE_INT_ARGB);

        while (scrolled < totalheight) {
            //File file = ScreenshotUtil.getScreenshotAsFile(driver);
            BufferedImage screen = SnapshotUtil.getSnapshot(driver).getSnap();//ImageIO.read(file);
            int scrollHeight = 0;
            scrollHeight = viewportHeight - stickyHeaderHeight - stickyFooterHeight;
            if (count == 1) {
                result = screen;
                //scrollHeight = viewportHeight - stickyHeaderHeight;
            } else if (totalheight - scrolled + stickyHeaderHeight > viewportHeight) {
                //scrollHeight = viewportHeight - stickyHeaderHeight;
                Rectangle cropArea = new Rectangle();
                cropArea.height = scrollHeight;
                cropArea.width = width;
                cropArea.x = 0;
                cropArea.y = stickyHeaderHeight;
                result = joinImagesVertically(result,
                    cropImage(screen, cropArea.x, cropArea.y, cropArea.width, cropArea.height));
            } else {
                //double fraction = ((double) totalheight - scrolled) / viewportHeight;
                int cropHeight = totalheight - scrolled;
                int cropWidth = width;
                int cropX = 0;
                int cropY = scrolled + stickyHeaderHeight;//viewportHeight - cropHeight;
                result = joinImagesVertically(result,
                    cropImage(screen, cropX, cropY, cropWidth, cropHeight));
                scrollHeight = cropHeight;
            }
            injector.execute(scrollTo(0, scrolled + scrollHeight));
            try {
                Thread.sleep(scrollTimeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrolled += scrollHeight;
            count++;
        }
        return result;
    }
}
