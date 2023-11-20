package com.silky.pocketbook.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.common.Response;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;

public class Controller {
    public static Response find(Object data){
        if(data != null){
            return Response.successFind(data);
        } else {
            return Response.fatalAsk("查询失败，请稍后再试");
        }
    }

    public static Response delete(int success) {
        if(success == 1) {
            return Response.successDelete();
        } else {
            return Response.fatalAsk("删除失败，请稍后再试");
        }
    }

    public static Response post(int success) {
        if(success == 1) {
            return Response.successPost();
        } else {
            return Response.fatalAsk("新增失败，请稍后再试");
        }
    }
    

    public static Response put(int success) {
        if(success == 1) {
            return Response.successPut();
        } else {
            return Response.fatalAsk("修改失败，请稍后再试");
        }
    }
}
