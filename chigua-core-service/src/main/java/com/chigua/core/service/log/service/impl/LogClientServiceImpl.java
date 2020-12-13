package com.chigua.core.service.log.service.impl;

import com.chigua.core.service.log.service.ILogApiService;
import com.chigua.core.service.log.service.ILogErrorService;
import com.chigua.core.service.log.service.ILogUsualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName: chigua-tool
 * ClassName: com.chigua.core.service.log.service.impl.LogClientServiceImpl
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 实现类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/08 - 17:57
 */
@Service
public class LogClientServiceImpl {
    @Autowired
    ILogUsualService usualLogService;
    @Autowired
    ILogApiService apiLogService;
    @Autowired
    ILogErrorService errorLogService;
}
