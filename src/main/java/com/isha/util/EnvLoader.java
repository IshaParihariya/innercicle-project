package com.isha.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    private static final Dotenv dotenv = loadDotenv();

    private static Dotenv loadDotenv() {
        String userDir = System.getProperty("user.dir");
        System.out.println("================================");
        System.out.println("LOADING .ENV FILE");
        System.out.println("user.dir: " + userDir);
        System.out.println("Looking for .env at: " + userDir + "/.env");
        System.out.println("================================");

        Dotenv env = Dotenv.configure()
                .directory(userDir)
                .ignoreIfMissing()
                .load();

        return env;
    }

    public static String get(String key) {
        String value = dotenv.get(key);
        System.out.println("EnvLoader.get('" + key + "') = " + (value != null ? "Found (" + value.length() + " chars)" : "NULL"));
        return value;
    }
}