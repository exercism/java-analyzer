import java.util.ArrayList;

class Hamming {
	String dna1=null;
	String dna2=null;

    Hamming(String leftStrand, String rightStrand) {

    	if(leftStrand == "" && rightStrand !="")
    		throw new IllegalArgumentException("left strand must not be empty.");
    	else if(rightStrand == "" && leftStrand !="")
    		throw new IllegalArgumentException("right strand must not be empty.");
    	else if(leftStrand.length()!=rightStrand.length())
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	else {
    		dna1=leftStrand;
    		dna2=rightStrand;
    	}
    }

    int getHammingDistance() {
    	char [] listOfPossibleValue= {'C','A','G','T'};
    	int counter=0;
    	int distance=0;
    	for(int i=0;i<dna1.length();i++) {
    		for(int y=0;y<listOfPossibleValue.length;y++) {
    			if(dna1.charAt(i)==listOfPossibleValue[y] || dna2.charAt(i)==listOfPossibleValue[y]) {
    				counter++;
    				if(dna1.charAt(i)==dna2.charAt(i)) {
    					counter++;
    				}
    			}
    			
    		}
    		if(counter !=2) {
    			throw new UnsupportedOperationException("DNA is not valid should contain C A G or T nothing else  ");
    		}
    		else {
    			if (dna1.charAt(i)!=dna2.charAt(i))
    				distance++;
    			counter=0;
    		}
    		
    	}
        return distance;
    }
    


}
