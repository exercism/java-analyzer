class Twofer {
	public static String phrase="One for X, one for me.";
    String twofer(String name) {
    	
    	
    while(true){
       try{
       	
       	phrase=phrase.replace("X",name);
     	return phrase;

     	
     }catch (java.lang.NullPointerException e){
     	
     	phrase=phrase.replace("X","you");
     	return phrase;
     	
     	
     }}
     /* else
       	return phrase=phrase.replace("X","you");
       }*/
    }
}
