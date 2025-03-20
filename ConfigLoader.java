/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.utils;

 import java.io.FileInputStream;
 import java.io.IOException;
 import java.util.Properties;
 
 public class ConfigLoader {
     private Properties properties;
     private static final String CONFIG_FILE = "config.properties";
 
     public ConfigLoader() {
         properties = new Properties();
         loadProperties();
     }
 
     private void loadProperties() {
         try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
             properties.load(fis);
         } catch (IOException e) {
             Logger.error("Failed to load configuration file: " + e.getMessage());
         }
     }
 
     public String getProperty(String key) {
         return properties.getProperty(key);
     }
 
     public int getIntProperty(String key, int defaultValue) {
         try {
             return Integer.parseInt(properties.getProperty(key));
         } catch (NumberFormatException e) {
             Logger.warn("Invalid integer value for key: " + key);
             return defaultValue;
         }
     }
 }
 