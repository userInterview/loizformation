package org.loiz.jvm.stacks;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoizMain {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		LoizMain objLoizMain = new LoizMain();
		objLoizMain.mainexec();
	}

	public void mainexec() {
		intLoizService objintLoizService = (intLoizService) context.getBean(implLoizService.class);
		objintLoizService.exploiteBean();
	}

}
