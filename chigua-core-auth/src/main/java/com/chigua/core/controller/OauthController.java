package com.chigua.core.controller;

import com.chigua.core.log.annotation.ApiLog;
import com.chigua.core.tool.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.controller.OauthController
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 重写认证接口（格式化自己的返回格式）
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/10 - 18:22
 */
@RestController
@RequestMapping("/oauth")
@Api(value = "授权管理",tags = "授权管理")
public class OauthController {
    @Autowired
    private TokenEndpoint tokenEndpoint;
    /**
     * =====================================
     * 描   述 : 自定义返回信息添加基本信息
     * 参   数 :  [principal, parameters]
     * 返 回 值 : com.chigua.core.tool.api.R
     * =====================================
     */
    @ApiOperation(value = "/token",tags = "获取token")
    @PostMapping("/token")
    @ResponseBody
    public R postAccessTokenWithUserInfo(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Map<String, Object> data = new LinkedHashMap();
        data.put("access_token", accessToken.getValue());
        if (accessToken.getRefreshToken() != null) {
            data.put("refresh_token", accessToken.getRefreshToken().getValue());
        }
        data.put("token_type",accessToken.getTokenType());
        data.put("expires_in",accessToken.getExpiresIn());
        //添加用户信息返回
        return R.data(data);
    }
}
