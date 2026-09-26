//WID(26.09.2026)(Sarthak Mittal)(JwtUtil)#11
package com.kafka.Carofly.config;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtUtil {
   private static final String SECRETKEY = "nZv7vIGZ6n/LzZhNCUYFQtcVyxZu+1JKiTQI7P6qPUk=";
    public JwtUtil jwtUtil;
    void setJwtUtil(JwtUtil jwtUtil){this.jwtUtil=jwtUtil;}
    private Key getSigningKey(){
        Byte[] byteskey=Decoders.BASE64.decode(SECRETKEY);
        return Keys.hmacShaKeyFor(byteskey);
    }
}
