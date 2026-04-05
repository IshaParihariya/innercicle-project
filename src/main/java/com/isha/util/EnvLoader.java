package com.isha.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    public static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}