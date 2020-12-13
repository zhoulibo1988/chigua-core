package com.chigua.core.service.oauth.service;

import com.chigua.core.mybatis.base.BaseService;
import com.chigua.core.service.oauth.entity.UserInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.service.UserService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description [用户服务接口]
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:09
 */
@Transactional(rollbackFor=Exception.class)
public interface IUserService extends BaseService<UserInfo> {
    /** *
     *  根据用户名查询用户
     * @param username	 username
     * @return com.chigua.core.service.oauth.entity.UserInfo
     * @author Mr.zhou
     * @date 2020-12-11
     */
    UserInfo getUserByName(String username);
    /**
     * 获取当前登录用户
     * @return com.chigua.core.service.oauth.entity.UserInfo
     * @author Mr.zhou
     * @date 2020-12-11
     */
    UserInfo getLogin();
}
