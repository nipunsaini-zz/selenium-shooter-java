package com.tftus.seleniumshooter.js;

import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

/**
 * Created by kumar.nipun on 15/08/18
 */
public class Scripts {

    private static final String FULL_PAGE_HEIGHT = "js/full_page_height.js";
    private static final String VIEWPORT_HEIGHT = "js/viewport_height.js";
    private static final String VIEWPORT_WIDTH = "js/viewport_width.js";

    private static String getScriptAsString(String path) {
        try {
            String script = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(path),
                StandardCharsets.UTF_8);
            return script;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFullPageScript() {
        return getScriptAsString(FULL_PAGE_HEIGHT);
    }

    public static String getViewportHeightScript() {
        return getScriptAsString(VIEWPORT_HEIGHT);
    }

    public static String getViewportWidthScript() {
        return getScriptAsString(VIEWPORT_WIDTH);
    }

    public static String scrollTo(int x, int y) {
        return String.format("window.scrollTo(%d, %d);", x, y);
    }
}
