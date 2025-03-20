/*
 * Copyright © 2025 Devin B. Royal.
 * All Rights Reserved.
 */

package com.novalink;

import com.novalink.core.encryption.AES256GCM;
import com.novalink.core.encryption.DHKEM_X25519_HKDF_SHA256;
import com.novalink.core.networking.RestClient;
import com.novalink.core.networking.GraphQLClient;
import com.novalink.core.security.OAuthHandler;
import com.novalink.core.security.APIKeyManager;
import com.novalink.utils.Logger;
import com.novalink.utils.ConfigLoader;

public class NovaLinkSDK {
    public static void main(String[] args) {
        try {
            Logger.log("Initializing NovaLink SDK...");
            
            // Load configurations
            ConfigLoader.loadConfig();
            
            // Initialize Security Module
            OAuthHandler authHandler = new OAuthHandler();
            APIKeyManager keyManager = new APIKeyManager();
            
            // Initialize Networking Module
            RestClient restClient = new RestClient();
            GraphQLClient graphQLClient = new GraphQLClient();
            
            // Initialize Encryption Module
            AES256GCM aes256 = new AES256GCM();
            DHKEM_X25519_HKDF_SHA256 dhkem = new DHKEM_X25519_HKDF_SHA256();
            
            Logger.log("NovaLink SDK initialized successfully.");
        } catch (Exception e) {
            Logger.error("Fatal error during SDK initialization: " + e.getMessage());
        }
    }
}
