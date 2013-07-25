/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security.mapper;

import org.springframework.stereotype.Repository;

import cn.javasoft.BaseMapper;
import cn.javasoft.security.model.UserModel;

/**
 * @author huangxiongxing
 * 
 *         2013-1-3 下午1:26:11
 */
@Repository("UserMapper")
public interface UserMapper extends BaseMapper<UserModel> {

	UserModel queryAllByUsername(String username);

	UserModel queryAllAndRolesById(String id);
}
