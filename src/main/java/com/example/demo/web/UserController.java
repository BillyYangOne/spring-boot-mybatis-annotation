package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;

@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers(){
		
		List<UserEntity> all = userMapper.getAll();
		return all;
		
	}
	
	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
		UserEntity one = userMapper.getOne(id);
		return one;
	}
	
	@RequestMapping("/addUser")
	public void addUser(UserEntity user) {
		userMapper.insert(user);
	}
	
	@RequestMapping("/updateUser")
	public void updateUser(UserEntity user) {
		userMapper.update(user);
	}
	
	@RequestMapping(value="/delete/{id}")
	public void deleteUser(@PathVariable("id")Long id) {
		userMapper.delete(id);
	}
	
}
