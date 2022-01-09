package com.example.gatewayserver.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class JasyptTest {

    @Autowired
    StringEncryptor encryptor;

    @Test
    @DisplayName("Jasypt 암/복호화 테스트")
    void encrypt(){
        // Given
        String data = "hello";
        String encryptData = encryptor.encrypt(data);
        // When
        String decryptData = encryptor.decrypt(encryptData);
        // Then
        assertEquals(data, decryptData, () -> "복호화된 값이 일치하지 않습니다.");
        System.out.println(encryptData);
    }
}