
package com.chigua.core.mybatis.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chigua.core.tool.constant.BladeConstant;
import com.chigua.core.tool.utils.DateUtil;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 业务封装基础类
 *
 * @param <M> mapper
 * @param <T> model
 * @author Chill
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

	@Override
	public boolean save(T entity) {
//		BladeUser user = SecureUtil.getUser();
//		if (user != null) {
//			entity.setCreateUser(1L);
//			entity.setUpdateUser(1L);
//		}
		Date now = DateUtil.now();
		entity.setCreateTime(now);
		entity.setUpdateTime(now);
		if (entity.getStatus() == null) {
			entity.setStatus(BladeConstant.DB_STATUS_NORMAL);
		}
		entity.setIsDeleted(BladeConstant.DB_NOT_DELETED);
		return super.save(entity);
	}

	@Override
	public boolean updateById(T entity) {
//		BladeUser user = SecureUtil.getUser();
//		if (user != null) {
//			entity.setUpdateUser(user.getUserId());
//		}
		entity.setUpdateTime(DateUtil.now());
		return super.updateById(entity);
	}

	@Override
	public boolean deleteLogic(@NotEmpty List<Long> ids) {
		return super.removeByIds(ids);
	}

}
