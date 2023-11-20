package com.silky.pocketbook.controller;

import cn.hutool.json.JSONObject;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.common.Response;
import com.silky.pocketbook.service.TokenService;
import com.silky.pocketbook.service.UserService;
import com.silky.pocketbook.util.Controller;
import com.silky.pocketbook.util.MyPasswordEncoder;
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
    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @PostMapping("/user/login")
    public Response login(@RequestBody User user) {
        int success = userservice.create(user);
        User loginUser = userservice.findUserByUserName(user.getUsername());
        if (loginUser == null) {
            return Response.fatal("用户不存在,登录失败");
        }

        if (!myPasswordEncoder.matches(user.getPassword(),
                loginUser.getPassword())) {
            return Response.fatal("登录失败，密码错误");
        } else {
            String token = tokenService.getToken(loginUser);
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("Authorization", token);
            return Response.success("登录成功", jsonObject);
        }
    }

    @PostMapping("/user/register")
    public Response register(@RequestBody User user) {
        int success = userservice.create(user);
        return Controller.result(success, "注册用户成功", "用户名已存在");
    }
}
