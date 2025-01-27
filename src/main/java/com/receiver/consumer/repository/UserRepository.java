package com.receiver.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegisteredFromClassic,Integer>{
	
	UserRegisteredFromClassic findBySerialId(Integer serialId);

}
