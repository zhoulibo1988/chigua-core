package com.chigua.core.service.oauth.service;


import com.chigua.core.mybatis.base.BaseService;
import com.chigua.core.service.oauth.entity.Perm;

import java.util.List;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.service.PermService
 * @author Mr.zhou <ijiami.cn>
 * @description [权限服务接口]
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:08
 */

public interface IPermService extends BaseService<Perm> {
    List<Perm> getPermByUserId(Long userId);
}
