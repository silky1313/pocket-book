package com.silky.pocketbook.interceptor;

import cn.hutool.json.JSONObject;
import com.silky.pocketbook.common.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GloablExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        System.out.println("hhhh");
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return Response.error(msg);
    }
}
