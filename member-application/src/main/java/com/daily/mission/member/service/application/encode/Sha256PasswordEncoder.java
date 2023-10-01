package com.daily.mission.member.service.application.encode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Component
public class Sha256PasswordEncoder implements PasswordEncoder {
    private static final String ALGORITHM = "SHA-256";
    @Override
    public String encode(CharSequence rawPassword) {
        String SHA = "";
        try {
            MessageDigest sh = MessageDigest.getInstance(ALGORITHM);
            sh.update(rawPassword.toString().getBytes(StandardCharsets.UTF_8));
            byte byteData[] = sh.digest();
            StringBuilder sb = new StringBuilder();
            for (byte data : byteData) {
                sb.append(Integer.toString((data & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            SHA = null;
        }
        return SHA;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String hashedRawPassword = encode(rawPassword.toString());
        return encodedPassword.equals(hashedRawPassword);
    }
}
