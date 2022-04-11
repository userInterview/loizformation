package org.loiz.jvm.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class implLoizService implements intLoizService {
	
	@Autowired
	interclasseManaged objinterclasseManaged ;
	
	public void exploiteBean() {
	/*classeManaged objclasseManaged = (classeManaged) context.getBean(classeManaged.class) ;
	objclasseManaged.lancement();*/
		objinterclasseManaged.lancement();		
	}
	

}
