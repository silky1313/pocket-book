package com.silky.pocketbook.common;

import com.silky.pocketbook.POJO.Kind;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    private HttpStatusCode code;
    private Object data;
    private String message;

    public static Response sendCode(HttpStatusCode code) {
        Response myResponse = new Response();
        myResponse.setCode(code);
        return myResponse;
    }

    public static Response sendMessage(String message, HttpStatusCode code) {
        Response myResponse = sendCode(code);
        myResponse.setMessage(message);
        return myResponse;
    }

    public static Response sendData(String message, HttpStatusCode code, Object data) {
        Response myResponse = sendMessage(message, code);
        myResponse.setData(data);
        return myResponse;
    }

    public static Response successFind(Object data) {
        return sendData("查询成功", HttpStatusCode.OK, data);
    }

    public static Response successDelete() {
        return sendMessage("删除成功", HttpStatusCode.NO_CONTENT);
    }
    public static Response successPost() {
        return sendMessage("新增成功", HttpStatusCode.CREATED);
    }
    public static Response successPut() {
        return sendMessage("修改成功", HttpStatusCode.OK);
    }
    public static Response fatalAsk(String msg) {
        return sendMessage(msg, HttpStatusCode.BAD_REQUEST);
    }
}
