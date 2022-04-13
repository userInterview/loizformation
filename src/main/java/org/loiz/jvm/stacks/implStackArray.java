package org.loiz.jvm.stacks;
import org.springframework.stereotype.Component;

@Component
public class implStackArray implements interfStackArray {

	public void viewArrays() {
		System.out.println("dans viewArrays - hashcode courant = " + this.hashCode());
		int tabint[] = null ;
		int[] tabentier ;
		
		tabint = new int[2];
		tabentier = new int[3];		
	}
	
	public  void viewInts() {
		int i  ;
		i = 10 ;
	}
	
	public  void viewStrings() {		
		String strAutre = "Hey !" ;						
		String strInterneAutre = new String ("Hey !") ;		
		strInterneAutre = strInterneAutre.intern() ;
		
		String objStrA = new String("salut") ;
		String strA = objStrA.toString() ;
		
		String objStrB = new String("salut") ;
		String strB = objStrB.toString() ;			
		String strD = objStrB.toString() ;
		
		System.out.println("hashcode de strA : " + strA.hashCode());		
		System.out.println("hashcode de strB : " + strB.hashCode());
	}

}
