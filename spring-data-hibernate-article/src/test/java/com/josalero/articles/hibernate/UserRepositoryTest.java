package com.josalero.articles.hibernate;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.josalero.articles.hibernate.model.User;
import com.josalero.articles.hibernate.repository.UserRepository;

@SpringBootTest
@DirtiesContext
public class UserRepositoryTest 
{
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Test
	public void test()
	{
		List<User> users = userRepository.findAll();
		
		users.stream().forEach(user -> System.out.println(user.getRoles()));
	}

}
