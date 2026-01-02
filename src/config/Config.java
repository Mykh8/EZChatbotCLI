package config;

import java.util.List;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    // Debug
    public static final boolean DEBUG = true;

    // Database
    public static final String DB_PATH = "data";

    // Valid input constants
    public static final List<Integer> VALID_MENU_OPTIONS = List.of(1, 2, 0);

    // Groq API
    public static final String GROQ_API_KEY;

    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
            GROQ_API_KEY = props.getProperty("GROQ_API_KEY");
        } catch (IOException e) {
            throw new  RuntimeException("Was not able to load config.properties", e);
        }
    }
}