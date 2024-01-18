package be.bstorm.tf_bestjava2023_springrcd.pl.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private byte[] secret = "Javanais, quel est votre métier ? ahou ahou ahou".getBytes(StandardCharsets.UTF_8);

    public int expireAt = 86400; // 1 Day

    public SecretKey secretKey = new SecretKeySpec(secret,"HmacSHA256");
}
