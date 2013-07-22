/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 
 * <P>此拦截器作用是在执行FILTER_SECURITY_INTERCEPTOR 拦截器前将数据库中的资源加载至内存中替代文件配置</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class ResourcesSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public void destroy() {

	}

	public void init(FilterConfig filterconfig) throws ServletException {

	}

}
