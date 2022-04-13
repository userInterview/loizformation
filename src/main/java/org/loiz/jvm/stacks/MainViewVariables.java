package org.loiz.jvm.stacks;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainViewVariables {

	@Autowired
	interfStackArray objStackArrayautowired;

	private static ApplicationContext context;

	public static void main(String[] args) throws InterruptedException {
		context = new ClassPathXmlApplicationContext("beans.xml");
		MainViewVariables objviewVariables = (MainViewVariables) context.getBean(MainViewVariables.class);
		System.out.println(objviewVariables.hashCode());
		
		objviewVariables.lancer();
		
		notmanaged.consulterBean();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i<=20 ; i++) {
				try {
					TimeUnit.SECONDS.sleep(2);
					if (i==20) i = 1 ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				System.out.println("t1 a tourne à l'itération " + i);
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i<=20 ; i++) {
				try {
					TimeUnit.SECONDS.sleep(2);
					if (i==20) i = 1 ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
				System.out.println("t2 a tourne à l'itération " + i);
				}
			}

		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}

	public void lancer() {
		objStackArrayautowired.viewStrings();
	}

	public static void listerBeans() {

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		System.out.println("\033[1mThis is a BOLD line\033[0m");
		String strTitleTabBeans = String.format("|| %-30s || %-20s", "\033[1mNom du bean\033[0m", "Scope du bean",
				"nom complet de classe");
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
