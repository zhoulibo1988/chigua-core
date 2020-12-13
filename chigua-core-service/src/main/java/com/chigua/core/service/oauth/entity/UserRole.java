package com.chigua.core.service.oauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chigua.core.mybatis.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.service.oauth.entity.UserRole
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 用户与角色关系表
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/11 - 16:29
 */

@Data
@TableName(value = "tb_user_role")
public class UserRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Integer roleId;

    private Long userId;


}
