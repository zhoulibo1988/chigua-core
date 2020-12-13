package com.chigua.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.config.AuthProperties
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 授权获取配置文件
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 12:26
 */
@Data
@Component
public class AuthProperties {
    @Value("${auth.accessTokenTime:43200}")
    private String accessTokenTime;
    @Value("${auth.refreshTokenTime:2592000}")
    private String refreshTokenTime;
}
