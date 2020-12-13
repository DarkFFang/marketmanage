package com.fang.marketmanage.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomGrantedAuthority implements GrantedAuthority {

    private String url;
    private String method;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.url + ";" + this.method;
    }
}
