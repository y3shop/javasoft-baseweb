/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public interface BaseMapper<M extends BaseObject> {

	int insertSelector(M m);

	int updateSelectorById(M m);

	M queryModelById(@Param("id") String id);

	List<M> queryModel();

	List<M> queryByPager(@Param("startPageNumber") Integer startPageNumber, @Param("pageSize") Integer pageSize);

	List<M> queryByPagerAndUserId(@Param("startPageNumber") Integer startPageNumber,
			@Param("pageSize") Integer pageSize, @Param("creator") String creator);

	int queryCountByUserId(@Param("creator") String creator);

	int queryCount();

	int deleteById(@Param("id") String idd);
}
