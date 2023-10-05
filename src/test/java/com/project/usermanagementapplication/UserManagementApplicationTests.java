package com.project.usermanagementapplication;

import com.project.usermanagementapplication.controller.UserController;
import com.project.usermanagementapplication.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManagementApplicationTests {

	@Autowired
	public UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	void TestSaveUser() {
		User user = new User();
		user.setfirstName("Satyam");
		user.setlastName("Sahu");
		user.setAge(23);
		userController.saveUser(user);
	}

}
