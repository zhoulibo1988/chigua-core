package com.chigua.core.log.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.log.exception.UsernameException
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户名不存在异常类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 15:04
 */
public class UsernameException extends AuthenticationException {
    public UsernameException(String message, Throwable t) {
        super(message, t);
    }

    public UsernameException(String message) {
        super(message);
    }
}
