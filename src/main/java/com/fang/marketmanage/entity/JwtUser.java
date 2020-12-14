package com.fang.marketmanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
/**
 * 类 {@code JwtUser 用户认证} .
 *
 * @author fang
 * @since 2020/12/14
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtUser implements UserDetails {
    /**
     * 版本
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 权限
     */
    private Collection<? extends GrantedAuthority> authorities;

    /**
     *返回用户编号
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *返回用户电话号码
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *返回用户权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     *返回用户名称
     * @return
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     *返回用户密码
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     *返回账号是否过期
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 返回账号是否锁定
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *返回用户凭证是否过期
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 返回是否可用
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
