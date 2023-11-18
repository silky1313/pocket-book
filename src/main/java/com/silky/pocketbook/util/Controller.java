package com.silky.pocketbook.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.common.Response;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Controller {

    /**
     *
     * @param success
     * @param successMsg
     * @param failMsg
     * @return 返回给客户端的ans
     */
    public static Response result(int success, String successMsg, String failMsg) {
        if(success == 1) {
            return Response.success(successMsg);
        }
        else {
            return Response.fatal(failMsg);
        }
    }
}
