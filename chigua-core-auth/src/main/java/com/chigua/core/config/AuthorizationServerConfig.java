package com.chigua.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassNameAuthorizationServerConfig
 * @Description [授权服务配置]
 * @Author Mr.Zhou
 * @Date2020/9/18 12:00
 * @Version V1.0
 **/
@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 密码加密验证规则
     *
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * Authentication认证令牌管理器
     *
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 用户实现接口类
     *
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Resource
    private UserDetailsService userDetailsService;
    /**
     * 数据源
     *
     * @author Mr.zhou
     * @date 2020-12-11
     */
    @Resource
    private DataSource dataSource;
    /**
     * 配置文件
     *
     * @author Mr.zhou
     * @date 2020-12-11
     */
    @Resource
    private AuthProperties authProperties;

    /**
     * 配置存放token的数据源
     *
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * 配置ClientDetails的数据源服务
     *
     * @param
     * @return org.springframework.security.oauth2.provider.ClientDetailsService
     * @author Mr.zhou
     * @date 2020-09-18
     */
    @Bean
    public ClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //配置认证管理器,支持密码模式
                .authenticationManager(authenticationManager)
                //用于支持刷新token
                .userDetailsService(userDetailsService)
                //配置token往数据库中写
                .tokenStore(tokenStore());
        //oAuth2.0中access_token默认有效时长为12个小时，refresh_token默认时长为30天。在实际运用中需要根据需求设置有效时长
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        //token有效期设置2个小时
        tokenServices.setAccessTokenValiditySeconds(Integer.valueOf(authProperties.getAccessTokenTime()));
        //Refresh_token:12个小时
        tokenServices.setRefreshTokenValiditySeconds(Integer.valueOf(authProperties.getRefreshTokenTime()));
        endpoints.tokenServices(tokenServices);
        log.info("chigua access_token 失效时间：{} ", authProperties.getAccessTokenTime());
        log.info("chigua refresh_token 失效时间：{} ", authProperties.getRefreshTokenTime());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置ClientDetails数据服务, 这里会获取数据库中oauth_client_details表的认证客户的信息
        clients.withClientDetails(jdbcClientDetailsService());
    }


}