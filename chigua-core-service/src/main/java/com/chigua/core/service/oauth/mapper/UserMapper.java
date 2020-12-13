package com.chigua.core.service.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.core.service.oauth.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.mapper.UserMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:41
 */
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {
}
