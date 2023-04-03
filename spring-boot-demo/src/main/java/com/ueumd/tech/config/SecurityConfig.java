package com.ueumd.tech.config;

import com.ueumd.tech.common.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 创建BCryptPasswordEncoder注入容器
     * 明文密码进行加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                // 自定义登录拦截URI
                .loginProcessingUrl("/user/login")
                .and()
                //token的验证方式不需要开启csrf的防护
                .csrf().disable()
                // 自定义认证失败类
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                // 自定义权限不足处理类
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                //设置无状态的连接,即不创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/common/getSystemDate").permitAll()
                //配置允许匿名访问的路径
                .anyRequest().authenticated();
        // 解决跨域问题（重要）  只有在前端请求接口时才发现需要这个
        httpSecurity.cors().and().csrf().disable();


        //配置自己的jwt验证过滤器
        httpSecurity
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);


        // disable page caching
        httpSecurity.headers().cacheControl();

        //.antMatchers("/admin/**").hasRole("ADMIN");配置只有ADMIN 权限的用户才能访问该路由
    }

    protected void configure2(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/user/login").anonymous()
                // .antMatchers("/testCors").hasAuthority("system:dept:list222")

                // 除上面外的所有请求全部需要鉴权认证 认证后的请求都可以访问

                .anyRequest().authenticated();

        //添加过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //配置异常处理器
        http.exceptionHandling()
                //配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler);

        //允许跨域
        http.cors();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
