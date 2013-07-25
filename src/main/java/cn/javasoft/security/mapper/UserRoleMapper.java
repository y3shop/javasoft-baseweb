/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.javasoft.BaseMapper;
import cn.javasoft.security.model.UserRoleModel;

/**
 * @author huangxiongxing
 * 
 *         2013-1-3 下午1:26:11
 */
@Repository("UserRoleMapper")
public interface UserRoleMapper extends BaseMapper<UserRoleModel> {

	int deleteByUserId(@Param("userId") String userId);
}
