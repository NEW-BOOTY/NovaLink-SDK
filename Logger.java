/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.utils;

 import java.io.FileWriter;
 import java.io.IOException;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 
 public class Logger {
     private static final String LOG_FILE = "novalink.log";
     private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
     public static void log(String level, String message) {
         String logMessage = String.format("[%s] [%s]: %s", DATE_FORMAT.format(new Date()), level, message);
         System.out.println(logMessage);
         writeToFile(logMessage);
     }
 
     public static void info(String message) {
         log("INFO", message);
     }
 
     public static void warn(String message) {
         log("WARN", message);
     }
 
     public static void error(String message) {
         log("ERROR", message);
     }
 
     private static void writeToFile(String message) {
         try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
             writer.write(message + "\n");
         } catch (IOException e) {
             System.err.println("[ERROR] Failed to write log to file: " + e.getMessage());
         }
     }
 }
 