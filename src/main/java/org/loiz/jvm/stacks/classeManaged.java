package org.loiz.jvm.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class classeManaged implements interclasseManaged {

	
	@Autowired 
	interfStackArray objinterfStackArray ;
	
	public void lancement() {
		objinterfStackArray.viewArrays();
		objinterfStackArray.viewInts();
		objinterfStackArray.viewStrings();				
	}	
	

}
