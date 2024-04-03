package com.receiver.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receiver.consumer.service.UserService;

import com.receiver.consumer.repository.UserRegisteredFromClassic;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/users-info")
	public List<UserRegisteredFromClassic> allUsers() throws Exception
	{
		return service.findAllUsersRegistered();
		
	}
	
	@GetMapping("/user-info/{serialId}")
	public UserRegisteredFromClassic getUserBySerialId(Integer serialId) throws Exception
	{
		return service.findUserBySerialId(serialId);
	}

}
