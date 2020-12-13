package com.chigua.core.service.oauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chigua.core.mybatis.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassNamePerm
 * @Description
 * @Author Mr.Zhou
 * @Date2020/9/18 12:31
 * @Version V1.0
 **/
@Data
@TableName(value = "tb_perm")
public class Perm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "perm_id",type = IdType.AUTO)
    private Integer permId;

    private String permName;


    private String permNameCn;
}
