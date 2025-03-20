/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.core.networking;

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.OutputStream;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.Map;
 
 public class GraphQLClient {
     private static final int TIMEOUT = 10000;
 
     public static String sendGraphQLRequest(String urlString, String query, Map<String, String> headers) throws Exception {
         URL url = new URL(urlString);
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("POST");
         connection.setConnectTimeout(TIMEOUT);
         connection.setReadTimeout(TIMEOUT);
         connection.setDoInput(true);
         connection.setDoOutput(true);
         
         if (headers != null) {
             for (Map.Entry<String, String> entry : headers.entrySet()) {
                 connection.setRequestProperty(entry.getKey(), entry.getValue());
             }
         }
         
         String payload = "{\"query\":\"" + query.replace("\"", "\\\"") + "\"}";
         try (OutputStream os = connection.getOutputStream()) {
             os.write(payload.getBytes());
             os.flush();
         }
         
         int responseCode = connection.getResponseCode();
         
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                 responseCode >= 200 && responseCode < 300 ? connection.getInputStream() : connection.getErrorStream()))) {
             StringBuilder response = new StringBuilder();
             String line;
             while ((line = reader.readLine()) != null) {
                 response.append(line);
             }
             return response.toString();
         }
     }
 }
 