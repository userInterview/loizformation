package org.loiz.jvm.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class classeManaged {
	
	@Autowired
	MainViewVariables objviewVariable ;
	
	public void lancement() {
		objviewVariable.lancer() ;	
	}	
	

}
