package org.loiz.jvm.stacks;
import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class viewVariables {
	
	
	@Autowired
	interfStackArray objStackArrayautowired; 
	
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");		
		viewVariables objviewVariables = (viewVariables) context.getBean(viewVariables.class) ;
		System.out.println(objviewVariables.hashCode());
		objviewVariables.lancer() ;
		notmanaged.consulterBean();
	}	
	
	
	public void lancer() {		
		objStackArrayautowired.viewStrings() ;
	}
	
	public static void listerBeans() {
		
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);		
		System.out.println("\033[1mThis is a BOLD line\033[0m");		
		String strTitleTabBeans = String.format("|| %-30s || %-20s",  "\033[1mNom du bean\033[0m", "Scope du bean", "nom complet de classe");		
		System.out.println(strTitleTabBeans);
		for (String beanName : beanNames) {
			String strClassBean = context.getBean(beanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {								
				String str = String.format("|| %-30s || %-20s", beanName, strClassBean);
				System.out.println(str);
			}
		}
	}
	
	public static boolean isBeanFromMyApp(String argStrClassBean) {
		return (argStrClassBean.indexOf("org.loiz.jvm.stacks") != -1);
	}

	
	
}
