package nhan.example.ws.jaxws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import nhan.example.dto.User;
import nhan.example.service.UserService;

@WebService
public class UserWS {

	//DI via Spring
    UserService userService;
	
	@WebMethod(exclude=true)
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@WebMethod(operationName="findAllUsers")
	public List<User> findAllUsers() {		
		return userService.findAllUsers();
		
	}
	
	@WebMethod(operationName="findById")
	public User findById(long id) {		
		return userService.findById(id);
		
	}
	
	@WebMethod(operationName="saveUser")
	public void saveUser(User user) {		
		userService.saveUser(user);
		
	}
	
	@WebMethod(operationName="updateUser")
	public void updateUser(User user) {
		userService.updateUser(user);
		
	}
}
