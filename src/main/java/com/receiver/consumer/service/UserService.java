package com.receiver.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receiver.consumer.UserRegisteredPayLoad;
import com.receiver.consumer.repository.UserRegisteredFromClassic;
import com.receiver.consumer.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public String addNewUser(UserRegisteredPayLoad toAdd)
	{
		UserRegisteredFromClassic toAddNewUser=new UserRegisteredFromClassic();
		toAddNewUser.setConfirmationCode(toAdd.getConfirmationCode());
		toAddNewUser.setEmailAddress(toAdd.getEmailAddress());
		toAddNewUser.setFullName(toAdd.getFullName());
		
		repo.save(toAddNewUser);
		return "The User was added to the database: "+toAdd.getConfirmationCode();
	}
	
	public UserRegisteredFromClassic findUserBySerialId(Integer serialId) throws Exception
	{
		UserRegisteredFromClassic found=repo.findBySerialId(serialId);
		if(found==null)
			throw new Exception("There was no user with this serialId");
		return found;
	}
	
	public List<UserRegisteredFromClassic> findAllUsersRegistered() throws Exception
	{
		List<UserRegisteredFromClassic> users=repo.findAll();
		if(users.isEmpty() || users==null) {
			throw new Exception("There are no users in the database to display here");
		}
		return users;
	}

}
