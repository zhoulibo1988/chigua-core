package com.chigua.core.log.config;

import com.chigua.core.log.aspect.ApiLogAspect;
import com.chigua.core.log.event.ApiLogListener;
import com.chigua.core.log.event.ErrorLogListener;
import com.chigua.core.log.event.UsualLogListener;
import com.chigua.core.log.logger.ChiGuaLogger;
import com.chigua.core.log.utils.ServerInfo;
import com.chigua.core.service.log.service.ILogClient;
import com.chigua.core.tool.props.ChiGuaProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志工具自动配置
 *
 * @author z.lb
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class ChiGuaLogToolAutoConfiguration {

	private final ILogClient logService;
	private final ServerInfo serverInfo;
	private final ChiGuaProperties bladeProperties;

	@Bean
	public ApiLogAspect apiLogAspect() {
		return new ApiLogAspect();
	}

	@Bean
	public ChiGuaLogger bladeLogger() {
		return new ChiGuaLogger();
	}

	@Bean
	public ApiLogListener apiLogListener() {
		return new ApiLogListener(logService, serverInfo, bladeProperties);
	}

	@Bean
	public ErrorLogListener errorEventListener() {
		return new ErrorLogListener(logService, serverInfo, bladeProperties);
	}

	@Bean
	public UsualLogListener bladeEventListener() {
		return new UsualLogListener(logService, serverInfo, bladeProperties);
	}

}
