package com.silky.pocketbook.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.silky.pocketbook.POJO.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${secret}")
    private String SECRET;

    @Value("${duration}")
    private Integer DURATION;
    /**
     *
     * @param user
     * @return 为user颁发的token令牌
     */
    public String getToken(User user) {
        String token = "";
        Date expiresAt = new Date(System.currentTimeMillis() + DURATION); // 设置过期时间为当前时间加上一个时间偏移量
        token = JWT.create()
                .withAudience(String.valueOf(user.getUsername()))
                .withExpiresAt(expiresAt) // 设置 Token 的过期时间
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }
}
