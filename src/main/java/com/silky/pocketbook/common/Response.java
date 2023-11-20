package com.silky.pocketbook.common;

import lombok.Data;

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
    public static Response success(String message) {
        return sendData(message, HttpStatusCode.OK, null);
    }
    public static Response success(String message, Object data) {
        return sendData(message, HttpStatusCode.OK,  data);
    }
    public static Response fatal(String message) {
        return sendData(message, HttpStatusCode.BAD_REQUEST, null);
    }
}
