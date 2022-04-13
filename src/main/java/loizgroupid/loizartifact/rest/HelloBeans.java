package loizgroupid.loizartifact.rest;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import loizgroupid.loizartifact.dto.pojouser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloBeans {

	private Logger logger = LoggerFactory.getLogger(HelloBeans.class);	

	@Autowired
	ConfigurableApplicationContext myACDepuisControleurRest;

	@GetMapping("/")
	public String bonjourRacine() {		
		return "à la racine";
	}

	@GetMapping("/hello")
	public String mappingBonjour() {
		logger.info("-------------- debut hello moucharder_bean");
		logBean("beanPrototypeJacques", "pojouser");
		logger.info("-------------- après hello moucharder_bean");
		return "Re-Bonjour à tous et à toutes";
	}

	@GetMapping("/hola")
	public String mappinghola() {
		logger.info("-------------- antes hola moucharder_second_bean");
		logBean("beanAppu", "pojouser");
		logger.info("-------------- despues hola moucharder_second_bean");
		return "Re-Bonjour à tous et à toutes";
	}

	@GetMapping("/listerbeans")
	public String mappinglisterbeans() {
		logger.info("-------------- /listerbeans : antes moucharder_bean");
		listerBeans();
		logger.info("-------------- /listerbeans : despues moucharder_bean");
		return "les beans sont listées";
	}

	public void listerBeans() {
		String[] beanNames = myACDepuisControleurRest.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		System.out.println("\033[1mThis is a BOLD line\033[0m");
		
		String strTitleTabBeans = String.format("|| %-30s || %-10s || %-20s",  "\033[1mNom du bean\033[0m", "Scope du bean", "nom complet de classe");
		
		System.out.println(strTitleTabBeans);
		for (String beanName : beanNames) {
			String strClassBean = myACDepuisControleurRest.getBean(beanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {
				String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(beanName).getScope();				
				String str = String.format("|| %-30s || %-10s || %-20s", beanName, strScope, strClassBean);
				System.out.println(str);
			}
		}
	}

	public boolean isBeanFromMyApp(String argStrClassBean) {
		return (argStrClassBean.indexOf("loizgroupid.loizartifact") != -1);
	}

	public void logBean(String strNomAppBean, String libelle) {
		pojouser objpojo = (pojouser) myACDepuisControleurRest.getBean(strNomAppBean);
		logger.info("{} >>> {}", libelle, objpojo);
		logger.info("nom {} >>> {}", libelle, objpojo.getNom());
		logger.info("prenom {} >>> {}", libelle, objpojo.getPrenom());
	}

	@GetMapping("/listerinstances")
	public String mappinglisterinstances() {
		logger.info("-------------- before mappinglisterinstances");
		getInstantiatedSingletons();
		logger.info("-------------- after mappinglisterinstances");
		return "les beans de types syngleton sont listés";
	}

	// Affichage des beans liés à l'aplication et affichage de leur type public
	void getInstantiatedSingletons() {
		String[] all = myACDepuisControleurRest.getBeanDefinitionNames();
		ConfigurableListableBeanFactory clbf = ((AbstractApplicationContext) myACDepuisControleurRest).getBeanFactory();
		for (String BeanName : all) {
			String strClassBean = myACDepuisControleurRest.getBean(BeanName).getClass().getName();
			if (isBeanFromMyApp(strClassBean)) {
				Object objSing = clbf.getSingleton(BeanName);
				if (objSing != null) {
					String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(BeanName).getScope();
					logger.info("BeanName " + BeanName + " de type \"" + strScope + "\"");
				} else {
					String strScope = myACDepuisControleurRest.getBeanFactory().getBeanDefinition(BeanName).getScope();
					logger.info("BeanName " + BeanName + "\"NON SINGLETON\" de type : \"" + strScope + "\"");
				}
			}
		}
	}

}