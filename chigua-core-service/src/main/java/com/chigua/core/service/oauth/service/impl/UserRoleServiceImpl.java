package com.chigua.core.service.oauth.service.impl;

import com.chigua.core.mybatis.base.BaseServiceImpl;
import com.chigua.core.service.oauth.entity.UserRole;
import com.chigua.core.service.oauth.mapper.UserRoleMapper;
import com.chigua.core.service.oauth.service.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.service.oauth.service.impl.UserRoleServiceImpl
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户与角色service
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 16:34
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
