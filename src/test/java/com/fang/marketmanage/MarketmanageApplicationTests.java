package com.fang.marketmanage;

import com.alibaba.fastjson.JSON;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.JwtTokenUtil;
import com.fang.marketmanage.util.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.annotation.Resource;

@SpringBootTest
class MarketmanageApplicationTests {


    @Autowired
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenBuild() {
        String phone="1582584862";
        JwtUser userDetails = (JwtUser) userService.loadUserByUsername(phone);
        System.out.println(userDetails.getAuthorities().toString());
        String token = JwtTokenUtil.createToken(userDetails);
        System.out.println(token);
        System.out.println(JwtTokenUtil.getUsernameFromToken(token));
        System.out.println(JwtTokenUtil.isExpiration(token));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        System.out.println(authenticationToken.toString());
    }

    @Test
    void tokenParse() {
        JwtParser parser = Jwts.parser();
        Claims body = parser
                .setSigningKey("Qnxj@xc!mk")
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJmYW5nIiwiZXhwIjoxNjA3MjQ3NzUwLCJpYXQiOjE2MDcxNjEzNTAsImF1dGhvcml0aWVzIjpbeyJ1cmwiOiIvYWRtaW4vdXNlci8qKiIsIm1ldGhvZCI6IkdFVCIsImF1dGhvcml0eSI6Ii9hZG1pbi91c2VyLyoqO0dFVCJ9LHsidXJsIjoiL2FkbWluL3VzZXIvKioiLCJtZXRob2QiOiJQT1NUIiwiYXV0aG9yaXR5IjoiL2FkbWluL3VzZXIvKio7UE9TVCJ9LHsidXJsIjoiL2FkbWluL3VzZXIvKioiLCJtZXRob2QiOiJQVVQiLCJhdXRob3JpdHkiOiIvYWRtaW4vdXNlci8qKjtQVVQifSx7InVybCI6Ii9hZG1pbi91c2VyLyoqIiwibWV0aG9kIjoiREVMRVRFIiwiYXV0aG9yaXR5IjoiL2FkbWluL3VzZXIvKio7REVMRVRFIn1dLCJ1c2VybmFtZSI6IuWwj-aYjiJ9.829tckwKzZulyec1ys3kHoqeBBaYwEYS7uV0j6p-81T-_SsW6d1BofhAyy7GQAdC56lJEPPxqrqCxROwqmsgKA")
                .getBody();
        String json=JSON.toJSONString(body);
        System.out.println(json);
        System.out.println(body.get("username").toString());
    }

    @Test
    void redisTest() {
        JwtUser jwtUser = (JwtUser) userService.loadUserByUsername("11111111");
        redisUtil.set(jwtUser.getId().toString(), jwtUser);
        System.out.println(redisUtil.get(jwtUser.getId().toString()).toString());
        System.out.println(redisUtil.get("testkey"));
        System.out.println(redisUtil.get("test"));
    }
}
