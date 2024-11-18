package test.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import test.user.filter.CustomAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationFilter customAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 可以根据需要启用或禁用 CSRF
            .authorizeRequests()
            .antMatchers("/login", "/register").permitAll() // 允许匿名访问
            .antMatchers("/students/**").authenticated()  // 需要认证的路径
            .anyRequest().authenticated() // 其他路径默认需要认证
            .and()
            .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // 添加自定义过滤器
    }
}
