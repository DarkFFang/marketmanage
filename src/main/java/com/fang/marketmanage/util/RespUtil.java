package com.fang.marketmanage.util;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespUtil {
    private String status;
    private String msg;

    public static RespUtil success(String msg) {
        return new RespUtil("success", msg);
    }

    public static RespUtil error(String msg) {
        return new RespUtil("error", msg);
    }

    public static void response(HttpServletResponse response, int httpStatus, Object object) {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(httpStatus);
        try {
            response.getWriter().write(JSON.toJSONString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
