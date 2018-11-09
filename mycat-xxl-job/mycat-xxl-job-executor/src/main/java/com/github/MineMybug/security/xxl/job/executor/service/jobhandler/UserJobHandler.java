/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月9日  
* @version 1.0  
*/
package com.github.MineMybug.security.xxl.job.executor.service.jobhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.MineMybug.security.xxl.job.core.biz.model.ReturnT;
import com.github.MineMybug.security.xxl.job.core.handler.IJobHandler;
import com.github.MineMybug.security.xxl.job.core.handler.annotation.JobHandler;
import com.github.MineMybug.security.xxl.job.executor.model.User;
import com.github.MineMybug.security.xxl.job.executor.service.userservice.UserServiceImpl;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月9日  
*/
@JobHandler(value="userJobHandler")
@Component
public class UserJobHandler extends IJobHandler{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		User user = new User();
		user.setUsername("weilong");
		user.setPassword("123456");
		user.setSex(1);
		user.setAge(32);
		userServiceImpl.saveUser(user);
		return SUCCESS;
	}
	
	

}
