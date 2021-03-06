package cn.javasoft.security;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import cn.javasoft.security.model.UserModel;

/**
 * 监听器 - 后台登录成功、登录失败处理 ============================================================================
 * 版权所有 2008-2010 长沙鼎诚软件有限公司,并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得SHOP++商业授权之前,您不能将本软件应用于商业用途,否则SHOP++将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.shopxx.net
 * ---------------------------------------------------------------------------- KEY:
 * SHOPXXB7062D10AE49E791318B72A663072500
 * ============================================================================
 */

public class AdminSecurityListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		// 登录成功：记录登录IP、清除登录失败次数
		if (applicationEvent instanceof AuthenticationSuccessEvent) {
			AuthenticationSuccessEvent authenticationSuccessEvent = (AuthenticationSuccessEvent) applicationEvent;
			Authentication authentication = (Authentication) authenticationSuccessEvent.getSource();
			String loginIp = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();
			UserModel userModel = (UserModel) authentication.getPrincipal();
			userModel.setLoginIp(loginIp);
		}

		// 登录失败：增加登录失败次数
		if (applicationEvent instanceof AuthenticationFailureBadCredentialsEvent) {
			AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent = (AuthenticationFailureBadCredentialsEvent) applicationEvent;
			Authentication authentication = (Authentication) authenticationFailureBadCredentialsEvent.getSource();
			String loginUsername = authentication.getName();

		}
	}

}