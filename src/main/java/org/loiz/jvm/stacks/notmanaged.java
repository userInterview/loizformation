package org.loiz.jvm.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class notmanaged {		
	

	public static void consulterBean() {		
		LoizThreadAwareclasse objloizAwareclasse = new LoizThreadAwareclasse() ;
		MainViewVariables objBeanviewVariables = (MainViewVariables) objloizAwareclasse.getBeanFromNonSpringManagedClass(MainViewVariables.class) ;
		System.out.println(objBeanviewVariables.hashCode());
		classeManaged objBeanclasseManaged = (classeManaged) objloizAwareclasse.getBeanFromNonSpringManagedClass(classeManaged.class) ;		
		objBeanclasseManaged.lancement();
	}
}
