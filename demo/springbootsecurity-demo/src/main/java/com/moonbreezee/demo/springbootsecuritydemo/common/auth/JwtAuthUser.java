package com.moonbreezee.demo.springbootsecuritydemo.common.auth;

import com.moonbreezee.demo.springbootsecuritydemo.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

//用户信息及用户信息服务
//加载用户信息，需要用户信息类及用户信息服务类。AuthUser继承spring的UserDetails，必须重写UserDetails的一些标准接口。注意与实体类User区别。
public class JwtAuthUser implements UserDetails {

  private static final long serialVersionUID = -2336372258701871345L;

  //用户实体类
  private JwtUser user;

  public JwtAuthUser(JwtUser user) {
    this.setUser(user);
  }

  public static Collection<? extends GrantedAuthority> getAuthoritiesByRole(String role) {
    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

    List<String> roles = Arrays.asList(role.split(","));
    if (roles.contains("user")) {
      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    if (roles.contains("admin")) {
      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    return authorities;
  }

  // 提供权限信息
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return getAuthoritiesByRole(getUser().getRole());
  }

  // 提供账号名称
  @Override
  public String getUsername() {
    return getUser().getMobile();
  }

  // 提供密码
  @Override
  public String getPassword() {
    return getUser().getPassword();
  }

  // 账号是否没过期，过期的用户无法认证
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // 账号是否没锁住，锁住的用户无法认证
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 密码是否没过期，密码过期的用户无法认证
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // 用户是否使能，未使能的用户无法认证
  @Override
  public boolean isEnabled() {
    return true;
  }

  public JwtUser getUser() {
    return user;
  }

  public void setUser(JwtUser user) {
    this.user = user;
  }

}
