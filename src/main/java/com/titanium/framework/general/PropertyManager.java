package com.titanium.framework.general;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") +
            "/src/main/java/com//titanium/framework/general/config.properties";
    private Properties properties = new Properties();

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Read configuration.properties file
        try {
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public String getProperty(String aProperty) {
        return properties.getProperty(aProperty);
    }
}
