package demo.bservice ;

import java.util.List;

import demo.dmodel.User;
//import demo.service.gesterrors.UserNotFoundException;


public interface InterfaceUserService {

		
	public List<User> getAllCategories() ;	

	public User findUser(Long lngId);

	boolean deleteUser(Long argId);

	boolean addUser(User objUser);

	User updateUser(User objUser);
}