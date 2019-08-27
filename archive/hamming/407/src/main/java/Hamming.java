import java.lang.*;

class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }

    int getHammingDistance() {
        int count = 0;
        if(leftStrand.length()!=rightStrand.length()) 
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        if(leftStrand.equals("")&&!rightStrand.equals("")) 
            throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.equals("")&&!leftStrand.equals("")) 
            throw new IllegalArgumentException("right strand must not be empty."); 

        for(int i=0; i<leftStrand.length(); i++){
            if(leftStrand.charAt(i)!=rightStrand.charAt(i))
                count++;
        }
        return count;   
    }

}
