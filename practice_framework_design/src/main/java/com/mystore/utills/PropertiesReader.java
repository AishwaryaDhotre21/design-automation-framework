package com.mystore.utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;
    public PropertiesReader() {
        properties = new Properties();
        try {
             FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\configuration\\config.propertise");
            //FileInputStream input=new FileInputStream("C:\\Users\\HP\\Desktop\\Automation_framework\\automation_framework_code\\configuration\\config.propertise");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
