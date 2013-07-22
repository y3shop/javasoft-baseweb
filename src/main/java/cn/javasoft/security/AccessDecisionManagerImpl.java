/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * <P>校验访问URL是否有权限，没有权限抛出AccessDeniedException</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	private static final Logger log = LoggerFactory.getLogger(AccessDecisionManagerImpl.class);

	/**
	 * 
	 * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication,
	 *      java.lang.Object, java.util.Collection)
	 */
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (log.isDebugEnabled()) {
			log.debug("decide access - start");
		}
		if (configAttributes == null) {
			if (log.isDebugEnabled()) {
				log.debug("decide access - end");
			}
			return;
		}
		if (log.isDebugEnabled()) {
			log.debug("current access url:[{}]", object.toString());
		}
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute configAttribute = ite.next();
			String needRole = ((SecurityConfig) configAttribute).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (log.isDebugEnabled()) {
					log.debug("need role is[{}],user role is[{}]", configAttribute.getAttribute(), ga.getAuthority());
				}
				if (needRole.equals(ga.getAuthority())) {
					if (log.isDebugEnabled()) {
						log.debug("decide access - end");
					}
					return;
				}
			}
		}
		throw new AccessDeniedException("sorry,dear,Do not have permission to access");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;

	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}