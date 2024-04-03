package com.receiver.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.receiver.consumer.service.UserService;

@Component
public class ManualConsumer {
	
	private static Logger logger=LoggerFactory.getLogger(ManualConsumer.class);
	
	@Autowired
	UserService service;
	
	@RabbitListener(queues="test_classic")
	public void handleMessage(Message message, Channel channel)
	{
		try
		{
			//Manually receiving single message
			logger.info("Received message: "+new String(message.getBody()));
			
			String toSendToService=new String(message.getBody());
			
			logger.info("Got the payload as: "+toSendToService.toString());
			
			//acknowledgement 
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			ObjectMapper objectMapper = new ObjectMapper();

	        TypeReference<UserRegisteredPayLoad> mapType = new TypeReference<UserRegisteredPayLoad>() {};
	        UserRegisteredPayLoad payload = objectMapper.readValue(toSendToService, mapType);

	        System.out.println("Message received");
	        System.out.println("User full name:    " + payload.getFullName());
	        System.out.println("Email Address:     " + payload.getEmailAddress());
	        System.out.println("Confirmation code: " + payload.getConfirmationCode());
	        
	        service.addNewUser(payload);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
