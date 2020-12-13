package com.chigua.core.service.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * ProjectName: chigua-tool
 * ClassName: com.chigua.core.log.entity.LogApi
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 日志记录实体类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/08 - 15:30
 */
@Data
@TableName("chigua_log_api")
public class LogApi extends LogAbstract implements Serializable {
    protected static final long serialVersionUID = 1L;
    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;
}
