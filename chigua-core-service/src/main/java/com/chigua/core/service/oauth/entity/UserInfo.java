package com.chigua.core.service.oauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chigua.core.mybatis.base.BaseEntity;
import io.github.classgraph.json.Id;
import lombok.Data;

import java.io.Serializable;

/**
 * ProjectName: springboot-security-oauth2.0
 * ClassName: com.chigua.springboot.oauth.entity.User
 *
 * @author Mr.zhou <ijiami.cn>
 * @description TODO
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/09/18 - 14:05
 */
@Data
@TableName(value = "tb_user")
public class UserInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    private String username;

    private String password;

    private Integer age;
}
