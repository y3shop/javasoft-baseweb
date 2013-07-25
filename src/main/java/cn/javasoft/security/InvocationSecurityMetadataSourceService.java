/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.javasoft.security.model.ResourceModel;

/**
 * 
 * <P>初始化从数据库中加载资源，通过URL得到资源集合</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Autowired
	private transient ResourceService resourceService;

	public void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<ResourceModel> resourceModels = resourceService.selectAllResource();
		for (ResourceModel resource : resourceModels) {
			String url = resource.getRecURL();
			ConfigAttribute configAttribute = new SecurityConfig(resource.getRecCode());
			if (resourceMap.containsKey(url)) {
				Collection<ConfigAttribute> configAttributes = resourceMap.get(url);
				configAttributes.add(configAttribute);
				resourceMap.put(url, configAttributes);
			} else {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				configAttributes.add(configAttribute);
				resourceMap.put(url, configAttributes);
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/**
	 * 根据URL，找到相关的权限配置。
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (url.equals(resURL)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}