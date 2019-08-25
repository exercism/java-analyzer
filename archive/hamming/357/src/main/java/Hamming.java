import java.util.Arrays;

class Hamming {
    String a1;        
    String a2;        

    Hamming(String leftStrand, String rightStrand) {
        a1 = leftStrand;        
        a2 = rightStrand;        

        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } 
        
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } 
        
        if (leftStrand.length() != rightStrand.length()) 
        {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        char arr1[] = a1.toCharArray();
        char arr2[] = a2.toCharArray();
        



        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                sum++;
            }
        }

        return sum;
    }

}
