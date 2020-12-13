package com.chigua.core.service.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.core.service.oauth.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.mapper.RoleMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:31
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
