package com.silky.pocketbook.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.annotation.UserLoginToken;
import com.silky.pocketbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 主要用于拦截权限请求
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Value("${secret}")
    private String serect;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object object) {
        //TODO: 从http请求头中取出 token
        String token = httpServletRequest.getHeader("Authorization");
        //TODO: 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Class<?> beanType = handlerMethod.getBeanType();
        //TODO: 这是需要用户登录才能访问的接口
        if (beanType.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = beanType.getAnnotation(UserLoginToken.class);
            if (token == null) {
                throw new RuntimeException("请重新登录");
            }

            //TODO: 获取 token 中的 user id,之前在Audience中放了一个id
            String username;
            try {
                username = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException j) {
                throw new RuntimeException("401");
            }
            User user = userService.findUserByUserName(username);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            //TODO: 验证 token,通过secret
            JWTVerifier jwtVerifier =
                    JWT.require(Algorithm.HMAC256(serect)).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new RuntimeException("401");
            }
            return true;
        }
        return true;
    }
}
