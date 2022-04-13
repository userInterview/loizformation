package demo;

//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import demo.crepository.UserRepositoryInterface;
import demo.dmodel.User;


@SpringBootApplication
@EnableTransactionManagement
public class LoizBootSpringDemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LoizBootSpringDemoApplication.class, args);
	}

	/*
	 * @Test public void testDummy1() { boolean bol = true;
	 * org.junit.Assert.assertTrue( bol==true ); }
	 */	
	
	@Autowired
	@Qualifier("myUserRepo")
	UserRepositoryInterface objBeanUser;

	@Override
	public void run(String... args) throws Exception {
		objBeanUser.save(new User("prenom1", "Nom1"));
		objBeanUser.save(new User("prenom2", "Nom3"));
		objBeanUser.save(new User("prenom3", "Nom3"));
		objBeanUser.save(new User("prenom4", "Nom4"));
		objBeanUser.save(new User("prenom5", "Nom5"));
		objBeanUser.save(new User("prenom6", "Nom6"));
		objBeanUser.save(new User("prenom7", "Nom7"));
		objBeanUser.save(new User("prenom8", "Nom8"));
		objBeanUser.save(new User("prenom9", "Nom9"));
		objBeanUser.save(new User("prenom10", "Nom10"));
		objBeanUser.save(new User("prenom11", "Nom11"));
		objBeanUser.save(new User("prenom12", "Nom12"));
		objBeanUser.save(new User("prenom13", "Nom13"));
		objBeanUser.save(new User("prenom14", "Nom14"));
		objBeanUser.save(new User("prenom15", "Nom15"));
		objBeanUser.save(new User("prenom16", "Nom16"));
		objBeanUser.save(new User("prenom17", "Nom17"));
		objBeanUser.save(new User("prenom18", "Nom18"));
		objBeanUser.save(new User("prenom19", "Nom19"));
		objBeanUser.save(new User("prenom20", "Nom20"));

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LoizBootSpringDemoApplication.class);
	}

}
