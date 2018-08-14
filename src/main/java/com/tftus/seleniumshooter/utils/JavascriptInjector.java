package com.tftus.seleniumshooter.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class JavascriptInjector {

    JavascriptExecutor js;

    public JavascriptInjector(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    public Object execute(String script, Object... arguments) {
        return js.executeScript(script, arguments);
    }

    public Object execute(File jsFile, Object... arguments) {
        return execute(FileUtil.getContent(jsFile), arguments);
    }
}
