package com.silky.pocketbook.util;

import com.silky.pocketbook.common.Response;

public class Controller {
    public static Response result(int success, String successMsg, String failMsg) {
        if(success == 1) {
            return Response.success(successMsg);
        }
        else {
            return Response.fatal(failMsg);
        }
    }
}
