package loizgroupid.loizartifact.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import loizgroupid.loizartifact.dto.pojouser;

@Configuration
public class AppConfigDeBeans {
 
    @Bean(name="beanAppu")    
	public pojouser methodBeanAppu() {
		return new pojouser("Apu","Ramiaranana") ;
	}
}