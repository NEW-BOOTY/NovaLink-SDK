# NovaLink SDK

## Overview
NovaLink SDK is a high-performance, secure, and cross-platform software development kit designed for seamless encryption, authentication, and network communication. It supports modern applications by providing robust security and networking functionalities.

## Features
- **Encryption**: AES-256-GCM, DHKEM_X25519_HKDF_SHA256
- **Networking**: REST and GraphQL client support
- **Authentication**: OAuth 2.0, API key management
- **Cross-Platform**: Works on Windows, Linux, macOS, Android, and iOS
- **Logging & Configuration**: Built-in logging and configuration management

## Installation
NovaLink SDK can be integrated using Maven or Gradle.

### Maven
```xml
<dependency>
    <groupId>com.novalink</groupId>
    <artifactId>sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
```gradle
dependencies {
    implementation 'com.novalink:sdk:1.0.0'
}
```

## Getting Started
Refer to the `docs/getting_started.md` guide for detailed setup and usage instructions.

## Usage Examples
### Making a REST API Call
```java
import com.novalink.core.networking.RestClient;

RestClient client = new RestClient("https://api.example.com");
String response = client.get("/data", accessToken);
```

### Sending a GraphQL Query
```java
import com.novalink.core.networking.GraphQLClient;

GraphQLClient gqlClient = new GraphQLClient("https://api.example.com/graphql");
String query = "{"query":"{ user { id name } }"}";
String gqlResponse = gqlClient.executeQuery(query, accessToken);
```

## Documentation
- **API Reference**: `docs/api_reference.md`
- **FAQ**: `docs/faq.md`

## License
This software is licensed under **proprietary terms**. See `LICENSE` for details.

## Contact
For support and inquiries, contact:
- **Email**: PAY_ME@MY.COM
- **Email**: JAVA-DEVELOPER@PROGRAMMER.NET
