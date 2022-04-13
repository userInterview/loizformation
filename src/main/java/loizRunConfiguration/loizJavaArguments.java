package loizRunConfiguration;

public class loizJavaArguments {

	public static void main(String[] args) {
		
		for (int i = 0 ; i < args.length ;i++)
		System.out.println(i + " : " + args[i]);		
		/* String stringPremier = "premiere chaine" ; String stringSeconde =
		 * "seconde chaine" ; String stringTroisieme = "troisieme chaine" ;*/		
		
		String stringPremier = System.getProperty("stringPremier") ; 
		String stringSeconde = ""   ;
		String stringTroisieme  = ""  ;
		
		System.out.println("stringPremier = " + stringPremier);
		System.out.println("stringSeconde  = " + stringSeconde);
		System.out.println("stringTroisieme = " + stringTroisieme);
		System.out.println("loizenv = " + System.getenv("loizenv"));
		

	}

}
