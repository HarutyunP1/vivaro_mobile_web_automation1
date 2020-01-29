package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author amalyahayrapetova
 */

public class PropertyConfig {


    private static Properties properties;


    private static void loadProperties(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(path));
    }

    public static String getProperty(String propertyPath,String property) throws IOException {
        loadProperties(propertyPath);
        return properties.getProperty(property);

    }

}
