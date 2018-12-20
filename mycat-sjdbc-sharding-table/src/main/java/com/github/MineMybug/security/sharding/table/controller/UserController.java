/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.MineMybug.security.sharding.table.domain.User;
import com.github.MineMybug.security.sharding.table.service.UserService;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月20日  
*/
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Object list() {
		return userService.list();
	}
	
	@GetMapping("/add")
	public Object add() {
		for (long i = 0; i < 100; i++) {
			User user = new User();
			user.setId(i);
			user.setCity("深圳");
			user.setName("李四");
			userService.add(user);
		}
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/users/query")
	public Object get(String name) {
		return userService.findByName(name);
	}
	

}
