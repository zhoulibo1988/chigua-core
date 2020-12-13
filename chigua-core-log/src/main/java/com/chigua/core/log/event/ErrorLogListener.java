
package com.chigua.core.log.event;


import com.chigua.core.log.constant.EventConstant;
import com.chigua.core.log.utils.LogAbstractUtil;
import com.chigua.core.log.utils.ServerInfo;
import com.chigua.core.service.log.entity.LogError;
import com.chigua.core.service.log.service.ILogClient;
import com.chigua.core.tool.props.ChiGuaProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * 异步监听错误日志事件
 *
 * @author z.lb
 */
@Slf4j
@AllArgsConstructor
public class ErrorLogListener {

	private final ILogClient logService;
	private final ServerInfo serverInfo;
	private final ChiGuaProperties chiGuaProperties;

	@Async
	@Order
	@EventListener(ErrorLogEvent.class)
	public void saveErrorLog(ErrorLogEvent event) {
		Map<String, Object> source = (Map<String, Object>) event.getSource();
		LogError logError = (LogError) source.get(EventConstant.EVENT_LOG);
		LogAbstractUtil.addOtherInfoToLog(logError, chiGuaProperties, serverInfo);
		logService.saveErrorLog(logError);
	}

}
