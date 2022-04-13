package demo.bservice ;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import demo.bservice.InterfaceUserService;
import demo.crepository.UserRepositoryInterface;
import demo.dmodel.User;
//import demo.service.gesterrors.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.beanutils.PropertyUtils; 

@Service
@Transactional
public class UserService implements InterfaceUserService {

	@Autowired
	UserRepositoryInterface objBeanUser ;
	
	public List<User> getAllCategories() {		

		return objBeanUser.findAll();
	}
	
	@Override
	public User findUser(Long argId) {		
		Optional<User> objOptionalUser = objBeanUser.findById(argId) ;
		User myUserFound = null ;
		if(objOptionalUser.isPresent())
			myUserFound = objOptionalUser.get() ; 
		return myUserFound ;
	}
	
	@Override
	public boolean deleteUser(Long argId) {
		boolean bSuccess;
		bSuccess = false ;
		objBeanUser.deleteById(argId); 		
		bSuccess = true ;
		return bSuccess ;		
	} 
	@Override
	public boolean addUser(User objUser) {
		boolean bSuccess;
		bSuccess = false ;
		objBeanUser.save(objUser);
		bSuccess = true ;
		return bSuccess ;		
	}
	
	@Override
	public User updateUser(User objUser) {
		boolean bSuccess = false ;			
		System.out.println("UserService > updateUser > objUser.toString() = " + objUser.toString() ) ;	
		try {
		objBeanUser.save(objUser);
		}
		catch(Exception e) { System.out.println("objBeanUser.save erreur :  " + e.getMessage()) ;} 
		bSuccess = true ;
		
		return objUser ;
		
	}
	
}