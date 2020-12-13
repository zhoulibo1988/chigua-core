package com.chigua.core.service.log.service.impl;

import com.chigua.core.service.log.entity.LogApi;
import com.chigua.core.service.log.entity.LogError;
import com.chigua.core.service.log.entity.LogUsual;
import com.chigua.core.service.log.service.ILogApiService;
import com.chigua.core.service.log.service.ILogClient;
import com.chigua.core.service.log.service.ILogErrorService;
import com.chigua.core.service.log.service.ILogUsualService;
import com.chigua.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.service.log.service.impl.LogClient
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 日记入库实现类
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/09 - 10:56
 */
@Service
public class LogClient implements ILogClient {
    @Autowired
    private ILogUsualService usualLogService;
    @Autowired
    private ILogApiService apiLogService;
    @Autowired
    private ILogErrorService errorLogService;
    @Override
    public R<Boolean> saveUsualLog(@RequestBody LogUsual log) {
        log.setParams(log.getParams().replace("&amp;", "&"));
        return R.data(usualLogService.save(log));
    }

    @Override
    public R<Boolean> saveApiLog(@RequestBody LogApi log) {
        log.setParams(log.getParams().replace("&amp;", "&"));
        return R.data(apiLogService.save(log));
    }

    @Override
    public R<Boolean> saveErrorLog(@RequestBody LogError log) {
        log.setParams(log.getParams().replace("&amp;", "&"));
        return R.data(errorLogService.save(log));
    }
}
