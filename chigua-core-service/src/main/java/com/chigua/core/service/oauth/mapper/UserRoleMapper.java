package com.chigua.core.service.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.core.service.oauth.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.service.oauth.mapper.UserRoleMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description UserRoleMapper
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 16:34
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
