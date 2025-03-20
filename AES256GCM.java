/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.core.encryption;

 import javax.crypto.Cipher;
 import javax.crypto.KeyGenerator;
 import javax.crypto.SecretKey;
 import javax.crypto.spec.GCMParameterSpec;
 import javax.crypto.spec.SecretKeySpec;
 import java.security.SecureRandom;
 import java.util.Base64;
 
 public class AES256GCM {
     private static final String ALGORITHM = "AES";
     private static final String TRANSFORMATION = "AES/GCM/NoPadding";
     private static final int KEY_SIZE = 256;
     private static final int GCM_TAG_LENGTH = 128;
     private static final int IV_SIZE = 12;
 
     public static SecretKey generateKey() throws Exception {
         KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
         keyGenerator.init(KEY_SIZE);
         return keyGenerator.generateKey();
     }
 
     public static byte[] generateIV() {
         byte[] iv = new byte[IV_SIZE];
         new SecureRandom().nextBytes(iv);
         return iv;
     }
 
     public static String encrypt(String plainText, SecretKey key, byte[] iv) throws Exception {
         Cipher cipher = Cipher.getInstance(TRANSFORMATION);
         GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
         cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
         byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
         return Base64.getEncoder().encodeToString(encryptedBytes);
     }
 
     public static String decrypt(String encryptedText, SecretKey key, byte[] iv) throws Exception {
         Cipher cipher = Cipher.getInstance(TRANSFORMATION);
         GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
         cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
         byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
         return new String(decryptedBytes);
     }
 }
 