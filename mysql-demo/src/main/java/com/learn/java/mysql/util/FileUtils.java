package com.learn.java.mysql.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileUtils {

    public static byte[] loadFileContent(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }
}
