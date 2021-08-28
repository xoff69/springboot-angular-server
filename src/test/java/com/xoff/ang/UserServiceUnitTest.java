package com.xoff.ang;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.xoff.ang.model.User;
import com.xoff.ang.repository.UserRepository;
import com.xoff.ang.web.UserController;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceUnitTest {
	
	 Logger logger = LoggerFactory.getLogger(UserServiceUnitTest.class);


	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void countUser() throws Exception {
		
		for (int i=0;i<5;i++) {
			
			User u=new User("n "+i,"adresse");
			u.setId(i);
			userRepository.save(u);
			logger.info("add  " + u.getName());
		}
		
		Iterable<User> allCustomer = userRepository.findAll();

		List<User> result = new ArrayList();
		allCustomer.iterator().forEachRemaining(result::add);
		Integer c = result.size();
		logger.info("nombre de user " + c);
		assertTrue(c > 3);

	}
}
