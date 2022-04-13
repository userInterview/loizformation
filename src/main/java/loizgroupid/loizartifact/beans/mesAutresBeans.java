package loizgroupid.loizartifact.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import loizgroupid.loizartifact.dto.pojouser;

@Configuration
public class mesAutresBeans {

	
	@Bean(name = "beanNameSoto")	
	@Scope("singleton")
	public pojouser methodBeanSOTOMAYOR() {		
		return new pojouser("SOTOMAYOR","Carlos") ;
	}
}
  