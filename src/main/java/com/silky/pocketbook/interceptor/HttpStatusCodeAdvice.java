package com.silky.pocketbook.interceptor;

import com.silky.pocketbook.common.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 这个全局处理类用来处理响应状态码
 */
@ControllerAdvice
public class HttpStatusCodeAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getParameterType().isAssignableFrom(Response.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body != null) {
            Response code = (Response) body;
            System.out.println(code.getCode().getCode());
            response.setStatusCode(HttpStatus.valueOf(code.getCode().getCode()));
        }
        return body;
    }
}
