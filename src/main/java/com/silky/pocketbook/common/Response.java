package com.silky.pocketbook.common;

import lombok.Data;

@Data
public class Response {
    private int code;

    private String message;

    private String type;

    private Boolean success;

    private Object data;

    public static Response success(String message) {
        Response myResponse = new Response();
        myResponse.setCode(200);
        myResponse.setMessage(message);
        myResponse.setSuccess(true);
        myResponse.setType("success");
        myResponse.setData(null);
        return myResponse;
    }

    public static Response success(String message, Object data) {
        Response myResponse = success(message);
        myResponse.setData(data);
        return myResponse;
    }

    public static Response warning(String message) {
        Response myResponse = error(message);
        myResponse.setType("warning");
        return myResponse;
    }

    public static Response error(String message) {
        Response myResponse = success(message);
        myResponse.setSuccess(false);
        myResponse.setType("error");
        return myResponse;
    }

    public static Response fatal(String message) {
        Response myResponse = error(message);
        myResponse.setCode(500);
        return myResponse;
    }
}
