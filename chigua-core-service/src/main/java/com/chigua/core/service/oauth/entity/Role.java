package com.chigua.core.service.oauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chigua.core.mybatis.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.entity.Role
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:05
 */

@Data
@TableName(value = "tb_role")
public class Role extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleNameCn;
}
