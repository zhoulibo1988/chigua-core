
package com.chigua.core.log.publisher;


import com.chigua.core.log.annotation.ApiLog;
import com.chigua.core.log.constant.EventConstant;
import com.chigua.core.log.event.ApiLogEvent;
import com.chigua.core.log.utils.LogAbstractUtil;
import com.chigua.core.service.log.entity.LogApi;
import com.chigua.core.tool.constant.BladeConstant;
import com.chigua.core.tool.utils.SpringUtil;
import com.chigua.core.tool.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * API日志信息事件发送
 *
 * @author z.lb
 */
public class ApiLogPublisher {

	public static void publishEvent(String methodName, String methodClass, ApiLog apiLog, long time) {
		HttpServletRequest request = WebUtil.getRequest();
		LogApi logApi = new LogApi();
		logApi.setType(BladeConstant.LOG_NORMAL_TYPE);
		logApi.setTitle(apiLog.value());
		logApi.setTime(String.valueOf(time));
		logApi.setMethodClass(methodClass);
		logApi.setMethodName(methodName);

		LogAbstractUtil.addRequestInfoToLog(request, logApi);
		Map<String, Object> event = new HashMap<>(16);
		event.put(EventConstant.EVENT_LOG, logApi);
		SpringUtil.publishEvent(new ApiLogEvent(event));
	}

}
