package com.silky.pocketbook.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.PocketBookApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class pocketControllerTest extends PocketBookApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    private String token;

    @BeforeEach
    public void loginAndGetToken() throws Exception {
        User user = new User();
        user.setUsername("123");
        user.setPassword(("123"));

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(user);
        // 发送登录请求并获取令牌
        String response =
                mockMvc.perform(MockMvcRequestBuilders.post("/user/login").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        token = extractTokenFromResponse(response);
    }

    @Test
    public void testSelectByUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pocket/1")
                        .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String extractTokenFromResponse(String response) {
        JSONObject jsonObject = JSONUtil.parseObj(response);
        String token = jsonObject.getStr("token");
        return token;
    }

}
