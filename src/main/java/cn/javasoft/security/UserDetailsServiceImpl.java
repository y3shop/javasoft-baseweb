/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.javasoft.cache.UserResourcesCache;

/**
 * @author huangxiongxing
 * 
 *         2013-1-6 下午10:03:25
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private transient ResourceService resourceService;

	@Autowired
	@Qualifier("UserResourcesCache")
	private transient UserResourcesCache userResourcesCache;

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.
	 * lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserModel userModel = resourceService.selectAllByUsername(username);
			userModel.setAuthorities(getAuthorities(userModel));
			return userModel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(UserModel userModel) throws Exception {
		return userResourcesCache.getAllResourcesById(userModel);
	}
}
