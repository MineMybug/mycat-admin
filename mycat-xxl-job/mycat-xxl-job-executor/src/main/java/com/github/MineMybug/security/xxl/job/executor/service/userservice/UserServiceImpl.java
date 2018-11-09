/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月9日  
* @version 1.0  
*/
package com.github.MineMybug.security.xxl.job.executor.service.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.MineMybug.security.xxl.job.executor.mapper.UserMapper;
import com.github.MineMybug.security.xxl.job.executor.model.User;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月9日  
*/
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int saveUser(User user) {
		int count = userMapper.save(user);
		return count;
	}

	@Override
	public int update(User user) {
		int count = userMapper.update(user);
		return count;
	}

	@Override
	public int deldeteId(int id) {
		int count = userMapper.deleteById(id);
		return count;
	}

	@Override
	public User selectById(int id) {
		User user = userMapper.selectById(id);
		return user;
	}

	@Override
	public List<User> selectAll() {
		List<User> users = userMapper.selectAll();
		return users;
	}

}
