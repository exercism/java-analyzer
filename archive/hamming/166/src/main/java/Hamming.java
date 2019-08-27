import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
class Hamming {
	String left="";
	String right="";
    Hamming(String leftStrand, String rightStrand) {
        left=leftStrand;
        right=rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {
    	int count=0;
    	if(left.length()==right.length()){
        	for(int i=0;i<right.length();i++){
        		if(left.charAt(i)!=right.charAt(i)){
        			count++;
        		}
        	}
        	return count;
        }
    	else if(left.length()==0){
    		System.out.println("Hi");
    		throw new IllegalArgumentException("left strand must not be empty.");
    	}
    	else if(right.length()==0){
    		throw new IllegalArgumentException("right strand must not be empty.");
    	}
        else if(left.length()!=right.length()){
        	throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        else{
        	return 0;
        }
    }
    public static void main(String[] args) {
    	expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand must not be empty.");
        new Hamming("", "G");
    }
}

