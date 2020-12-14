package com.chigua.core.config;

import com.chigua.core.filter.CustomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

/**
 * @ClassNameResourceServerConfig
 * @Description [资源服务配置]
 * @Author Mr.Zhou
 * @Date2020/9/18 16:19
 * @Version V1.0
 **/
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private AuthExceptionHandler authExceptionHandler;
    @Bean
    public CustomFilter customFilter(){ //添加自定义的过滤器
        return new CustomFilter();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                //STATELESS不创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources","/swagger-resources/configuration/security",
                        "/swagger-ui.html","/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index","/doc.html","/captcha")
                .permitAll()
                //对应认证服务器中用户的权限
                .antMatchers("/admin/**").hasAuthority("PERM_ADMIN_SELECT")
                .antMatchers("/admin/delete").hasAuthority("PERM_ADMIN_DELETE")
                .antMatchers("/user/**").hasAuthority("PERM_USER_SELECT")
                .antMatchers("/user/delete").hasAuthority("PERM_USER_DELETE").anyRequest().authenticated()
                .and()
                //加入过滤器链,在进入后者之前就进行过滤
                .addFilterBefore(customFilter(), WebAsyncManagerIntegrationFilter.class);
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //认证失败自定义处理
        resources.accessDeniedHandler(authExceptionHandler).authenticationEntryPoint(authExceptionHandler);
    }
}
