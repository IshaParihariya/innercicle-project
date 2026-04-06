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

        return Dotenv.configure()
                .directory(userDir)
                .ignoreIfMissing()
                .load();
    }

    public static String get(String key) {

        //  1. Try system environment (Render)
        String value = System.getenv(key);

        if (value != null) {
            System.out.println("EnvLoader: Found " + key + " in SYSTEM ENV");
            return value;
        }

        //  2. Fallback to .env (local)
        value = dotenv.get(key);

        System.out.println("EnvLoader: " + key + " from .env = " +
                (value != null ? "Found (" + value.length() + " chars)" : "NULL"));

        return value;
    }
}