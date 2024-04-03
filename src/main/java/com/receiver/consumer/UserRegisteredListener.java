package com.receiver.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.receiver.consumer.repository.UserRepository;
import com.receiver.consumer.service.UserService;

@Component
public class UserRegisteredListener {
	
	@Autowired
	UserService service;
	
		
	public void onMessageReceived(String message) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<UserRegisteredPayLoad> mapType = new TypeReference<UserRegisteredPayLoad>() {};
        UserRegisteredPayLoad payload = objectMapper.readValue(message, mapType);

        System.out.println("Message received");
        System.out.println("User full name:    " + payload.getFullName());
        System.out.println("Email Address:     " + payload.getEmailAddress());
        System.out.println("Confirmation code: " + payload.getConfirmationCode());
        
        service.addNewUser(payload);
		
	}

}
