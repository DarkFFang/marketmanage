package com.fang.marketmanage.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义授权
 *
 * @author fang
 * @date 2020/12/14
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomGrantedAuthority implements GrantedAuthority {

    /**
     * url
     */
    private String url;
    /**
     * 方法
     */
    private String method;

    /**
     * 得到授权
     *
     * @return {@link String}
     */
    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.url + ";" + this.method;
    }
}
