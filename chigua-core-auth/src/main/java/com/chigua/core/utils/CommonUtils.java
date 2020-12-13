package com.chigua.core.utils;

import com.chigua.core.tool.api.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.utils.CommonUtils
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 自定义认证失败异常返回
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 09:17
 */
@Slf4j
public class CommonUtils {
    /**
     * =====================================
     * 描   述 : Auth2.0 异常封装
     * 参   数 :  [request, response, authException, objectMapper,exceptionType]
     * 返 回 值 : void
     * 创 建 人 :  z.lb
     * =====================================
     */
    public static void authException(HttpServletRequest request, HttpServletResponse response, Exception authException, ObjectMapper objectMapper, int exceptionType) throws IOException {
        log.info("认证失败，禁止访问 {}", request.getRequestURI());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter printWriter = response.getWriter();
        if (1 == exceptionType) {
            printWriter.append(objectMapper.writeValueAsString(R.fail(AuthExceptionCode.OAUTH_TOKEN_DENIED, AuthExceptionCodeMsg.OAUTH_TOKEN_DENIED_MSG)));
        } else if (2 == exceptionType) {
            Throwable cause = authException.getCause();
            if (cause instanceof InvalidTokenException) {
                printWriter.append(objectMapper.writeValueAsString(R.fail(AuthExceptionCode.OAUTH_TOKEN_FAILURE, AuthExceptionCodeMsg.OAUTH_TOKEN_FAILURE_MSG)));
            } else {

                printWriter.append(objectMapper.writeValueAsString(R.fail(AuthExceptionCode.OAUTH_TOKEN_MISSING, AuthExceptionCodeMsg.OAUTH_TOKEN_MISSING_MSG)));
            }
        } else {
            printWriter.append(objectMapper.writeValueAsString(R.fail(AuthExceptionCode.OAUTH_TOKEN_OTHER, "认证失败，禁止访问：" + authException)));
        }
    }
}
