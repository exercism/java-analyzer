public class Hamming {

    String leftStrand;
    String rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        int length1 = leftStrand.length();
        int length2 = rightStrand.length();
        
        if(length1 == 0 & length2 != 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        if(length2 == 0 & length1 != 0)
            throw new IllegalArgumentException("right strand must not be empty.");
        if( length1 != length2)
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int i,count = 0, len = leftStrand.length();
        for (i = 0 ; i < len ; i++){
            if(leftStrand.charAt(i) != rightStrand.charAt(i) )
                count++;
        }
        return count;
    }

}
