package com.tt.common.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtil {

	public static boolean valid(String content) {
		boolean isNull = StringUtils.isBlank(content);
		if (!isNull) {
			if ((content.contains("Bad Gateway:"))||content.contains("对不起，您要浏览的网页可能被删除，重命名或者暂时不可用")
					||content.contains("系统检测到您正在使用网页抓取工具访问安居客网站，请卸载删除后访问")
					||content.contains("Gateway Timeout")||content.contains("错误: 不能获取请求的 URL")||content.contains("400 Bad Request")
					||content.contains("抱歉！页面无法访问")||content.contains("抱歉！页面暂时无法访问")
					||content.contains("<title>验证中心</title>")||content.contains("Unauthorized")
					||content.contains("The requested URL could not be retrieved")|| content.contains("403 Forbidden")||content.contains("404 Not Found")||content.contains("301 Moved Permanently")) {
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
}
