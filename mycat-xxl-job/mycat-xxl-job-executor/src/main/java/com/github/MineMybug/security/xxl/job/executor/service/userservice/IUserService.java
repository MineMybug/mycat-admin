/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月9日  
* @version 1.0  
*/
package com.github.MineMybug.security.xxl.job.executor.service.userservice;
import java.util.List;

import com.github.MineMybug.security.xxl.job.executor.model.User;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年11月9日
 */
public interface IUserService {

	public int saveUser(User user);
	
	public int update(User user);
	
	public int deldeteId(int id);
	
	public User selectById(int id);
	
	public List<User> selectAll();

}
