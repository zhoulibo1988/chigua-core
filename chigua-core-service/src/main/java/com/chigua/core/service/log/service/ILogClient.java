package com.chigua.core.service.log.service;

import com.chigua.core.service.log.entity.LogApi;
import com.chigua.core.service.log.entity.LogError;
import com.chigua.core.service.log.entity.LogUsual;
import com.chigua.core.tool.api.R;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ProjectName: chigua-tool
 * ClassName: com.chigua.core.service.log.service.LogClientService1
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 日志服务接口类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/08 - 17:51
 */
public interface ILogClient {
    /**
     * 保存错误日志
     *
     * @param log 日志实体
     * @return boolean
     */
    R<Boolean> saveUsualLog(@RequestBody LogUsual log);

    /**
     * 保存操作日志
     *
     * @param log 日志实体
     * @return boolean
     */
    R<Boolean> saveApiLog(@RequestBody LogApi log);

    /**
     * 保存错误日志
     *
     * @param log 日志实体
     * @return boolean
     */
    R<Boolean> saveErrorLog(@RequestBody LogError log);
}
