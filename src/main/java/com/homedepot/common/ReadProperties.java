package com.homedepot.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private Properties properties;

    public ReadProperties(String fileName) {
        properties = new Properties();
        load(fileName);
    }

    private void load(String fileName) {
        try {
            InputStream resourceAsStream = ReadProperties.class.getResourceAsStream("/" + fileName + ".properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println(fileName + " - Not Found");
        }
    }

    public String getKey(String key) {
        System.out.println("------" + key);
        return properties.getProperty(key);
    }

}