package com.chigua.core.utils;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.utils.ResponseStatusCodeConstant
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 自定义认证失败异常返回 常量定义类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 10:18
 */
public class AuthExceptionCode {
    private AuthExceptionCode() {

    }

    /**
     * token 失效
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final int OAUTH_TOKEN_FAILURE = 2001;
    /**
     * token 缺失
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final int OAUTH_TOKEN_MISSING = 2002;
    /**
     * token 权限不足
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final int OAUTH_TOKEN_DENIED = 2003;
    /**
     * token 其他
     *
     * @return
     * @author Mr.zhou
     * @date 2020-12-11
     */
    public static final int OAUTH_TOKEN_OTHER = 2004;
}
