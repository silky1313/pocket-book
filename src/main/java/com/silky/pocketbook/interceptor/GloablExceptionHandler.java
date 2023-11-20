package com.silky.pocketbook.interceptor;

import cn.hutool.json.JSONObject;
import com.silky.pocketbook.common.HttpStatusCode;
import com.silky.pocketbook.common.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice 是进行全局错误模式
 * 返回值处理 @ResponseBody
 */
@ControllerAdvice
@ResponseBody
public class GloablExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        } else if(msg.equals("401")) {
            return Response.sendCode(HttpStatusCode.UNAUTHORIZED);
        }
        return Response.fatal(msg);
    }
}
