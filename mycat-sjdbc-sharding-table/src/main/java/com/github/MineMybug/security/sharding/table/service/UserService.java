/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.MineMybug.security.sharding.table.domain.User;
import com.github.MineMybug.security.sharding.table.repository.UserRepository;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月20日  
*/
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> list() {
		return userRepository.list();
	}

	public Long add(User user) {
		return userRepository.addUser(user);
	}

	public User findById(Long id) {
		return userRepository.findById(id);
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

}
