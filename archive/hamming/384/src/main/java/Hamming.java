class Hamming {

	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

    	this.leftStrand=leftStrand;
    	this.rightStrand=rightStrand;
        
       if((leftStrand.length()>0) && (rightStrand.length()>0)){
       if ((leftStrand.length()>rightStrand.length()) || (leftStrand.length()< rightStrand.length()) ) {
       	  throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
       }
        }

       if((((leftStrand.isEmpty()) && (rightStrand.length() > 0)))){
       		throw new IllegalArgumentException("left strand must not be empty.");
       }

       if(((leftStrand.length() > 0) && (rightStrand.isEmpty()))){
       		throw new IllegalArgumentException("right strand must not be empty.");
       }




    }

    int getHammingDistance() {
         char [] statementLeft=this.leftStrand.toCharArray();
         char [] statementRight=this.rightStrand.toCharArray();

         int cont=0;

         for (int i=0; i<statementRight.length ;i++) {
         	if (statementLeft[i]!=statementRight[i]) {
         		cont++;
         	}
         }

         	return cont;

    }

}
