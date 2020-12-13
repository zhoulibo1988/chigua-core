package com.chigua.core.log.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.log.exception.PasswordException
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 密码错误
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 15:06
 */

public class PasswordException extends OAuth2Exception {
    public PasswordException(String message, Throwable t) {
        super(message, t);
    }

    public PasswordException(String message) {
        super(message);
    }
    @Override
    public int getHttpErrorCode() {
        return 302;
    }
}
