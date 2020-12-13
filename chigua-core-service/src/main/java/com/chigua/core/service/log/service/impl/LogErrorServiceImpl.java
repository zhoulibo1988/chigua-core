package com.chigua.core.service.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chigua.core.mybatis.base.BaseServiceImpl;
import com.chigua.core.service.log.entity.LogError;
import com.chigua.core.service.log.mapper.LogErrorMapper;
import com.chigua.core.service.log.service.ILogErrorService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author z.lb
 * @since 2018-09-26
 */
@Service
public class LogErrorServiceImpl extends BaseServiceImpl<LogErrorMapper, LogError> implements ILogErrorService {

}
