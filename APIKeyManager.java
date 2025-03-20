/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.core.security;

 import java.util.HashMap;
 import java.util.Map;
 
 public class APIKeyManager {
     private Map<String, String> apiKeys;
 
     public APIKeyManager() {
         this.apiKeys = new HashMap<>();
     }
 
     public void addApiKey(String service, String apiKey) {
         apiKeys.put(service, apiKey);
     }
 
     public String getApiKey(String service) {
         return apiKeys.get(service);
     }
 
     public boolean removeApiKey(String service) {
         if (apiKeys.containsKey(service)) {
             apiKeys.remove(service);
             return true;
         }
         return false;
     }
 
     public boolean isValidKey(String service, String key) {
         return apiKeys.containsKey(service) && apiKeys.get(service).equals(key);
     }
 }
 