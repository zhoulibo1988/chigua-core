package com.chigua.core.log.utils;
import com.chigua.core.service.log.entity.LogAbstract;
import com.chigua.core.tool.props.ChiGuaProperties;
import com.chigua.core.tool.utils.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Log 相关工具
 *
 * @author z.lb
 */
public class LogAbstractUtil {

	/**
	 * 向log中添加补齐request的信息
	 *
	 * @param request     请求
	 * @param logAbstract 日志基础类
	 */
	public static void addRequestInfoToLog(HttpServletRequest request, LogAbstract logAbstract) {
		if (ObjectUtil.isNotEmpty(request)) {
			logAbstract.setRemoteIp(WebUtil.getIP(request));
			logAbstract.setUserAgent(request.getHeader(WebUtil.USER_AGENT_HEADER));
			logAbstract.setRequestUri(UrlUtil.getPath(request.getRequestURI()));
			logAbstract.setMethod(request.getMethod());
			logAbstract.setParams(WebUtil.getRequestParamString(request));
			logAbstract.setCreateBy("admin");
		}
	}

	/**
	 * 向log中添加补齐其他的信息（eg：chigua、server等）
	 *
	 * @param logAbstract     日志基础类
	 * @param chiGuaProperties 配置信息
	 * @param serverInfo      服务信息
	 */
	public static void addOtherInfoToLog(LogAbstract logAbstract, ChiGuaProperties chiGuaProperties, ServerInfo serverInfo) {
		logAbstract.setServiceId(chiGuaProperties.getName());
		logAbstract.setServerHost(serverInfo.getHostName());
		logAbstract.setServerIp(serverInfo.getIpWithPort());
		logAbstract.setEnv(chiGuaProperties.getEnv());
		logAbstract.setCreateTime(DateUtil.now());

		//这里判断一下params为null的情况，否则chigua-log服务在解析该字段的时候，可能会报出NPE
		if (logAbstract.getParams() == null) {
			logAbstract.setParams(StringPool.EMPTY);
		}
	}
}
