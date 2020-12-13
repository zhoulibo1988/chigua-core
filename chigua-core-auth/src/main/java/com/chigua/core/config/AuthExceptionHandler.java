package com.chigua.core.config;

import com.chigua.core.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.config.AuthExceptionHandler
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 09:15
 */
@Component
public class AuthExceptionHandler extends OAuth2AccessDeniedHandler implements AuthenticationEntryPoint, AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException {
        //权限不足
        CommonUtils.authException(request, response, authException,objectMapper,1);
    }
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //无效token
        CommonUtils.authException(httpServletRequest,httpServletResponse,e,objectMapper,2);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        CommonUtils.authException(httpServletRequest,httpServletResponse,e,objectMapper,3);
    }
}
