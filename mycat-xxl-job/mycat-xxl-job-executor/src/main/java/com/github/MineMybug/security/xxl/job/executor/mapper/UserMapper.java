/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月9日  
* @version 1.0  
*/
package com.github.MineMybug.security.xxl.job.executor.mapper;

import java.util.List;

import com.github.MineMybug.security.xxl.job.executor.model.User;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月9日  
*/
public interface UserMapper {
	
	/**
     * 新增用户
     * @param user
     * @return
     */
    int save (User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update (User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById (int id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User selectById (int id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll ();

}
