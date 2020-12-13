package com.chigua.core.service.oauth.service.impl;

import com.chigua.core.mybatis.base.BaseServiceImpl;
import com.chigua.core.service.oauth.entity.Perm;
import com.chigua.core.service.oauth.mapper.PermMapper;
import com.chigua.core.service.oauth.service.IPermService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNamePermServiceImpl
 * @Description [权限服务实现]
 * @Author Mr.Zhou
 * @Date2020/9/18 14:59
 * @Version V1.0
 **/
@Service
@Transactional
public class PermServiceImpl extends BaseServiceImpl<PermMapper, Perm> implements IPermService {
    @Resource
    private PermMapper permMapper;
    @Override
    public List<Perm> getPermByUserId(Long userId) {
        return permMapper.findAllByUserId(userId);
    }
}
