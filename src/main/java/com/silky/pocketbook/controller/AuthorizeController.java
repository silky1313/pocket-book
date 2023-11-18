package com.silky.pocketbook.controller;

import cn.hutool.json.JSONObject;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.common.Response;
import com.silky.pocketbook.service.TokenService;
import com.silky.pocketbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizeController {
    @Autowired
    private UserService userservice;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/user/login")
    public Response login(@RequestBody User user) {
        User loginUser = userservice.findUserById(user.getId());
        if(loginUser == null) return Response.error("登录失败，用户不存在");
        if(!user.getPassword().equals(loginUser.getPassword())) {
            return Response.fatal("登录失败，密码错误");
        } else {
            String token = tokenService.getToken(loginUser);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Authorization", token);
            return Response.success("登录成功", jsonObject);
        }
    }
}
