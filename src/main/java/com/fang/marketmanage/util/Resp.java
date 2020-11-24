package com.fang.marketmanage.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resp {
    private String status;
    private String msg;

    public static Resp success(String msg)
    {
        return new Resp("success",msg);
    }

    public static Resp error(String msg)
    {
        return new Resp("error",msg);
    }
}
