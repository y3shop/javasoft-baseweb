/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-3-5 上午10:57:21
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.serializer.JSONSerializer;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class BaseController<E extends BaseObject> {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private static final String HEADER_ENCODING = "UTF-8";
	private static final boolean HEADER_NO_CACHE = true;
	private static final String HEADER_JSON_CONTENT_TYPE = "application/json";
	private static final String HEADER_TEXT_CONTENT_TYPE = "text/plain";

	protected static final String STATUS_PARAMETER_NAME = "status";// 操作状态参数名称
	protected static final String MESSAGE_PARAMETER_NAME = "message";// 操作消息参数名称

	protected static final String STATUS_SUCCESS = "success";
	protected static final String STATUS_FAIL = "fail";

	protected String redirectUrl = "";

	public String getBasePath() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		return basePath;
	}

	protected ModelMap isAddAction(ModelMap modelMap) {
		modelMap.put("isAddAction", true);
		return modelMap;
	}

	protected ModelMap isEditAction(ModelMap modelMap) {
		modelMap.put("isAddAction", false);
		return modelMap;
	}

	/**
	 * 
	 * <p>ajax返回json信息</p>
	 * 
	 * @param response
	 * @param status
	 * @param message
	 * @throws IOException
	 * 
	 */
	protected void ajax(HttpServletResponse response, String status, String message) throws IOException {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS_PARAMETER_NAME, status);
		jsonMap.put(MESSAGE_PARAMETER_NAME, message);
		initHttpServletResponse(response, HEADER_JSON_CONTENT_TYPE);
		JSONSerializer.write(response.getWriter(), jsonMap);
	}

	protected void ajax(HttpServletResponse response, Map<String, Object> jsonMap) throws IOException {
		initHttpServletResponse(response, HEADER_JSON_CONTENT_TYPE);
		JSONSerializer.write(response.getWriter(), jsonMap);
	}

	// 根据文本内容输出AJAX
	protected void ajaxText(HttpServletResponse response, String text) throws IOException {
		initHttpServletResponse(response, HEADER_TEXT_CONTENT_TYPE);
		response.getWriter().print(text);
	}

	/**
	 * 
	 * <p>初始化HttpServletResponse</p>
	 * 
	 * @param response
	 * @param contentType
	 * 
	 */
	private void initHttpServletResponse(HttpServletResponse response, String contentType) {
		response.setHeader("Content-Type", contentType);
		response.setContentType(contentType + ";charset=" + HEADER_ENCODING);
		if (HEADER_NO_CACHE) {
			response.setDateHeader("Expires", 1L);
			response.addHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		}
	}

}
