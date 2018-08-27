package com.tftus.seleniumshooter.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class ImageUtil {

    public static BufferedImage cropImage(BufferedImage image, int x, int y, int width, int height) {
        width = Math.min(width, image.getWidth());
        height = Math.min(height, image.getHeight());
        return image.getSubimage(x, y, width, height);
    }

    public static BufferedImage joinImagesVertically(BufferedImage image1, BufferedImage image2) {
        int width = Math.max(image1.getWidth(), image2.getWidth());
        int height = image1.getHeight() + image2.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        Color oldColor = g2.getColor();
        g2.setPaint(Color.BLACK);
        g2.fillRect(0, 0, width, height);
        g2.setColor(oldColor);
        g2.drawImage(image1, null, 0, 0);
        g2.drawImage(image2, null, 0, image1.getHeight());
        g2.dispose();
        return newImage;
    }

    public static BufferedImage scale(BufferedImage image, int targetWidth, int targetHeight) {

        int imageType = (image.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = image;

        do {
            width = (width/2 < targetWidth) ? targetWidth : width/2;
            height = (height/2 < targetHeight) ? targetHeight : height/2;

            BufferedImage temp = new BufferedImage(width, height, imageType);
            Graphics2D graphics2D = temp.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics2D.drawImage(resultImage, 0, 0, width, height, null);
            graphics2D.dispose();

            resultImage = temp;
        } while (width != targetWidth || height != targetHeight);

        return resultImage;
    }
}
