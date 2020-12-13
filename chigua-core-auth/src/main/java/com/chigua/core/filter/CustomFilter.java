package com.chigua.core.filter;/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.filter.CustomFilter
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 16:23
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassNameCustomFilter
 * @Description [自定义的过滤器, 可以打印访问者的信息]
 * @Author Mr.Zhou
 * @Date2020/9/18 16:23
 * @Version V1.0
 **/
public class CustomFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //将请求交给下面的过滤器
        filterChain.doFilter(request, response);
    }
}
