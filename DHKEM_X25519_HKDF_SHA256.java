/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

 package com.novalink.core.encryption;

 import java.security.KeyPair;
 import java.security.PrivateKey;
 import java.security.PublicKey;
 import java.security.SecureRandom;
 import java.util.Base64;
 import javax.crypto.KeyAgreement;
 import javax.crypto.Mac;
 import javax.crypto.spec.SecretKeySpec;
 import org.bouncycastle.jce.provider.BouncyCastleProvider;
 import java.security.Security;
 import org.bouncycastle.jcajce.provider.asymmetric.x25519.BCX25519PrivateKey;
 import org.bouncycastle.jcajce.provider.asymmetric.x25519.BCX25519PublicKey;
 import org.bouncycastle.jcajce.spec.X25519ParameterSpec;
 
 public class DHKEM_X25519_HKDF_SHA256 {
     static {
         Security.addProvider(new BouncyCastleProvider());
     }
 
     public static KeyPair generateKeyPair() throws Exception {
         java.security.KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("X25519", "BC");
         return keyPairGenerator.generateKeyPair();
     }
 
     public static byte[] deriveSharedSecret(PrivateKey privateKey, PublicKey publicKey) throws Exception {
         KeyAgreement keyAgreement = KeyAgreement.getInstance("X25519", "BC");
         keyAgreement.init(privateKey);
         keyAgreement.doPhase(publicKey, true);
         return keyAgreement.generateSecret();
     }
 
     public static byte[] hkdfExpand(byte[] inputKeyingMaterial, byte[] salt, int length) throws Exception {
         Mac mac = Mac.getInstance("HmacSHA256");
         mac.init(new SecretKeySpec(salt, "HmacSHA256"));
         byte[] prk = mac.doFinal(inputKeyingMaterial);
 
         mac.init(new SecretKeySpec(prk, "HmacSHA256"));
         return mac.doFinal(new byte[length]);
     }
 
     public static String encodeKey(PublicKey key) {
         return Base64.getEncoder().encodeToString(key.getEncoded());
     }
 
     public static String encodeKey(PrivateKey key) {
         return Base64.getEncoder().encodeToString(key.getEncoded());
     }
 }
 