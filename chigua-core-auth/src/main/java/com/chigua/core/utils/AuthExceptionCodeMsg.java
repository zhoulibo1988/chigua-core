package com.chigua.core.utils;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.utils.AuthExceptionCodeMsg
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 自定义认证失败异常返回常量定义类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 10:30
 */
public class AuthExceptionCodeMsg {

    public AuthExceptionCodeMsg() {

    }

    /**
     * token 失效
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final String OAUTH_TOKEN_FAILURE_MSG = "token 失效";
    /**
     * token 缺失
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final String OAUTH_TOKEN_MISSING_MSG = "token 缺失";
    /**
     * token 权限不足
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final String OAUTH_TOKEN_DENIED_MSG = "token 权限不足";
}
