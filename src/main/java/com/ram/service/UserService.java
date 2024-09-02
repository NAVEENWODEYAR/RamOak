
package com.ram.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ram.model.Users;
import com.ram.repository.UsersRepo;

/**
 * @author NaveenWodeyar
 * @date 02-Sept-2024
 */
@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UsersRepo usersRepo;
	
	// schedule an job to add to db(every 5 sec)
	@Scheduled(fixedRate = 1000)
	public void addToDB() {
		Users users = new Users();
			  users.setName("user"+new Random().nextInt(345753));
			  usersRepo.save(users);
			  System.out.println("Add service call in "+new Date().toString());
			  log.info("Users object saved");
	}
	
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchFromDB() {
		List<Users> usersList = usersRepo.findAll();
		System.out.println("Fetch service call in "+new Date().toString());
		System.out.println("No of records found "+usersList.size());
		log.info("Users : {}",usersList);
	}
	

}
