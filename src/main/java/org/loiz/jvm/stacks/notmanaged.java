package org.loiz.jvm.stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class notmanaged {		
	

	public static void consulterBean() {		
		loizAwareclasse objloizAwareclasse = new loizAwareclasse() ;
		viewVariables objBeanviewVariables = (viewVariables) objloizAwareclasse.getBeanFromNonSpringManagedClass(viewVariables.class) ;
		System.out.println(objBeanviewVariables.hashCode());
		classeManaged objBeanclasseManaged = (classeManaged) objloizAwareclasse.getBeanFromNonSpringManagedClass(classeManaged.class) ;		
		objBeanclasseManaged.lancement();
	}
}
