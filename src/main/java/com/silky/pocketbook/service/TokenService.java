package com.silky.pocketbook.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.silky.pocketbook.POJO.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${secret}")
    private String secret;

    /**
     *
     * @param user
     * @return 为user颁发的token令牌
     */
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getId())) // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(secret)); // 以 password 作为 token 的密钥
        return token;
    }
}
