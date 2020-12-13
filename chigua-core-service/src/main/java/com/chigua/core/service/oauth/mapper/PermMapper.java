package com.chigua.core.service.oauth.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chigua.core.service.oauth.entity.Perm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.mapper.PermMapper
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:11
 */
@Mapper
public interface PermMapper extends BaseMapper<Perm> {

    List<Perm> findAllByUserId(@Param("userId") Long userId);
}
