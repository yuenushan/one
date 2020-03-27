package com.example.util;

import java.nio.file.Paths;

public class MyFiles {
    public static String getResourceDir() {
        return MyFiles.class.getResource("/").getPath();
    }

    public static String getResourceStr(String filename) {
        return Paths.get(getResourceDir(), filename).toString();
    }


}
