/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table.repository;

import java.util.List;

import com.github.MineMybug.security.sharding.table.domain.User;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年12月20日
 */
public interface UserRepository {

	Long addUser(User user);

	List<User> list();

	User findById(Long id);

	User findByName(String name);

}
