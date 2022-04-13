package org.loiz.jvm.stacks;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
 
@Component
public class LoizThreadAwareclasse implements ApplicationContextAware {
     
    private static ApplicationContext context;     

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		LoizThreadAwareclasse.context = applicationContext;
	}     	
    
    public  <T extends Object> T getBeanFromNonSpringManagedClass(Class<T> nompointclass) {
    	return context.getBean(nompointclass);
    }       
}