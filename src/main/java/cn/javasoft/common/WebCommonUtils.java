/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-3-5 下午08:09:24
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft.common;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang.time.DateFormatUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class WebCommonUtils {

	private static final AtomicLong longGenerator = new AtomicLong(System.nanoTime());

	/**
	 * 用于生成不重复序列号
	 * 
	 * @return
	 */
	public static String getSequence() {
		String dateFormat = DateFormatUtils.format(new Date(), "MMdd");
		return dateFormat + longGenerator.incrementAndGet();
	}

	/**
	 * 
	 * <p>将对象转换成json字符串</p>
	 * 
	 * @param obj
	 * @return
	 * 
	 */
	public static String toJsonString(Object obj) {
		return JSONObject.toJSONString(obj);
	}

	public static void main(String[] args) {
		System.out.println(getSequence() + ":" + getSequence().length());
	}

	public static String toTempleName(String templePath) {
		String templeName = null;
		if (templePath.indexOf("/") > 0) {
			templeName = templePath.substring(templePath.indexOf("/") + 1, templePath.length());
		}
		if (templePath.indexOf("\\") > 0) {
			templeName = templePath.substring(templePath.indexOf("\\") + 1, templePath.length());
		}
		return templeName;
	}
}
