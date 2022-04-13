package demo.actrl ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import demo.bservice.InterfaceUserService;
import demo.dmodel.User;
//import demo.service.gesterrors.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ui.Model;


@Controller
public class RestUserManager {
	
	// Inject via application.properties
	@Value("${welcome.message}") private String attrBienvenueMsg;
	
	@Autowired
	InterfaceUserService attrUserService ;

	@RequestMapping("/")
	public String index() {
        return "index.html";                
    }
	
	@RequestMapping("/helloAccepted202")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<String>("Hello World!", HttpStatus.ACCEPTED);
	}
	
	private void myPause() {
		 try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@CrossOrigin
	@ResponseBody
	public List<User> listerUsers() {
		//myPause() ; 
		List<User> objListUsers = attrUserService.getAllCategories() ;
		for(User eleUser:objListUsers)
			System.out.println("listerUsers  : " + eleUser.getFirstName());
		return objListUsers ;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@CrossOrigin
	@ResponseBody
	public ResponseEntity<User> fetchUser(@PathVariable("id") String strId, HttpServletRequest request) {
		Long lngId = Long.parseLong(strId) ;
		System.out.println("fetchUser > lngId : " + lngId);
		User objUser = attrUserService.findUser(lngId) ;
		System.out.println("fetchUser > objUser.getFirstName() : " + objUser.getFirstName());
		System.out.println("fetchUser   > request.getContextPath() : " + request.getContextPath());
		return new ResponseEntity<User>(objUser, HttpStatus.OK);
	}
	  
	   @RequestMapping(value = "/redirect", method = RequestMethod.GET)
	   public String redirect() {
		   return "redirect:/errorpage.html" ;
	   }

	
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String gestionErreur(EmptyResultDataAccessException e) {
    	System.out.println("******************************** DEBUT ERREUR ********************************");
        System.out.println("RestUserManager > gestionErreur : avant redirection : " + e.getLocalizedMessage());
        System.out.println("******************************** FIN ERREUR *********************************");
        return redirect() ;
    } 
    
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public MyResponseType myExceptionHandler() {
//        return new MyResponseType();
//    }
	 
	@RequestMapping(value = "/users/remove/{id}", method = RequestMethod.DELETE)
	@CrossOrigin
  public ResponseEntity<String> deleteUser( @PathVariable("id") String strId ) {
		Long lngId = Long.parseLong(strId) ;
		boolean bol = false ;
		HttpHeaders httpHeaders = new HttpHeaders(); 
		  httpHeaders.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
		try {
		bol = attrUserService.deleteUser(lngId) ;		
		if (bol)
			return  new ResponseEntity<String>("removed", httpHeaders, HttpStatus.OK);
		else
			return  new ResponseEntity<String>("not found", httpHeaders, HttpStatus.NOT_FOUND);		
		}
		catch (Exception e) {
			return  new ResponseEntity<String>("error on remove", httpHeaders, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public List<User>  addUser( @RequestBody User argUser ) {
		//myPause() ;
		boolean bSuccess = attrUserService.addUser(argUser) ;
		 return( attrUserService.getAllCategories()) ;
	}	
	
	@RequestMapping(value = "/users/update/{suffix}", method = RequestMethod.PUT)
	@CrossOrigin
	@ResponseBody
	public void  updateUser( @PathVariable("suffix") String strSuffix, @RequestBody User argUser )  {
		User updatedUser =  null ;
		System.out.println("updateUser > argUser : ") ;		
		System.out.println("updateUser > argUser : argUser.toString() " + argUser.toString());
		updatedUser = attrUserService.updateUser(argUser) ;
	}	
	
}
