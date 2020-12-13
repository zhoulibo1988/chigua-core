package com.chigua.core.log.event;

import com.chigua.core.log.constant.EventConstant;
import com.chigua.core.log.utils.LogAbstractUtil;
import com.chigua.core.log.utils.ServerInfo;
import com.chigua.core.service.log.entity.LogApi;
import com.chigua.core.service.log.service.ILogClient;
import com.chigua.core.tool.props.ChiGuaProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;


/**
 * 异步监听日志事件
 *
 * @author z.lb
 */
@Slf4j
@AllArgsConstructor
public class ApiLogListener {

	private final ILogClient logService;
	private final ServerInfo serverInfo;
	private final ChiGuaProperties chiGuaProperties;


	@Async
	@Order
	@EventListener(ApiLogEvent.class)
	public void saveApiLog(ApiLogEvent event) {
		Map<String, Object> source = (Map<String, Object>) event.getSource();
		LogApi logApi = (LogApi) source.get(EventConstant.EVENT_LOG);
		LogAbstractUtil.addOtherInfoToLog(logApi, chiGuaProperties, serverInfo);
		logService.saveApiLog(logApi);
	}

}
