import java.util.*;

class Hamming {

    private String leftStrand;
    private String rightStrand;
    private static final HashMap<Integer, String> MSG = new HashMap<>();

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
	getHammingDistance();
    }

    int getHammingDistance() {

        int leftStranLength = this.leftStrand.length();
        int rightStranLength = this.rightStrand.length();
        int count = 0;

        try {
            if (leftStranLength == rightStranLength){
                char[] leftStrandChar = this.leftStrand.toCharArray();
                char[] rightStrandChar = this.rightStrand.toCharArray();


                for (int i=0; i<leftStranLength; i++){
                    if (leftStrandChar[i] != rightStrandChar[i]){
                        count++;
                    }
                }
            }else {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            if (leftStranLength == 0 || rightStranLength == 0) {
                throw new IllegalArgumentException(String.format("%s strand must not be empty.",
                        this.leftStrand.isEmpty()? "left" : "right"));

            } else if (leftStranLength != rightStranLength) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

            }
        }

        return count;
    }
}

