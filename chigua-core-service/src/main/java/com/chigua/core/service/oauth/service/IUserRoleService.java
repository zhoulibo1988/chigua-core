package com.chigua.core.service.oauth.service;

import com.chigua.core.mybatis.base.BaseService;
import com.chigua.core.service.oauth.entity.UserRole;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.service.oauth.service.IUserRoleService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户与角色service
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 16:32
 */
@Transactional(rollbackFor=Exception.class)
public interface IUserRoleService  extends BaseService<UserRole> {
}
