package com.chigua.core.service.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.chigua.core.mybatis.base.BaseEntity;
import com.chigua.core.tool.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ProjectName: chigua-tool
 * ClassName: com.chigua.core.log.entity.LogAbstract
 *
 * @author Mr.zhou <ijiami.cn>
 * @description logApi、logError、logUsual的父类，拥有相同的属性值
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/08 - 15:31
 */
@Data
public class LogAbstract extends BaseEntity implements Serializable {
    protected static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    protected Long id;

    /**
     * 服务ID
     */
    protected String serviceId;
    /**
     * 服务器 ip
     */
    protected String serverIp;
    /**
     * 服务器名
     */
    protected String serverHost;
    /**
     * 环境
     */
    protected String env;
    /**
     * 操作IP地址
     */
    protected String remoteIp;
    /**
     * 用户代理
     */
    protected String userAgent;
    /**
     * 请求URI
     */
    protected String requestUri;
    /**
     * 操作方式
     */
    protected String method;
    /**
     * 方法类
     */
    protected String methodClass;
    /**
     * 方法名
     */
    protected String methodName;
    /**
     * 操作提交的数据
     */
    protected String params;
    /**
     * 执行时间
     */
    protected String time;

    /**
     * 创建人
     */
    protected String createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    protected Date createTime;
}
