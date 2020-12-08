package com.fang.marketmanage.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class CustomGrantedAuthority implements GrantedAuthority {

    private String url;
    private String method;

    @Override
    public String getAuthority() {
        return this.url + ";" + this.method;
    }
}
