package com.tftus.seleniumshooter.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kumar.nipun on 13/08/18
 */
public class FileUtil {

    public static String getContent(File file) {
        try {
            return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + file.getAbsolutePath() + " : " + e.getMessage());
        }
    }
}
