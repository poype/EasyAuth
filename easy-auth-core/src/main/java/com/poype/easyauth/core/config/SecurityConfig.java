package com.poype.easyauth.core.config;

import com.poype.easyauth.core.common.filter.CheckAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CheckAuthenticationFilter checkAuthenticationFilter;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 关闭csrf
            .csrf().disable()
            // 不通过session获取SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 登录接口允许匿名访问
            .antMatchers("/admin/login").anonymous()
            // 其它接口都需要认证
            .anyRequest().authenticated();

        // 把checkAuthenticationFilter 添加在 UsernamePasswordAuthenticationFilter的前面
        http.addFilterBefore(checkAuthenticationFilter, LogoutFilter.class);
    }
}
