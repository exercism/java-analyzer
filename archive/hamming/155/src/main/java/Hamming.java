import java.util.*;
class Hamming {
    String leftStrand,rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
        if(rightStrand.length() == 0 && leftStrand.length() != 0)
            throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length() == 0 && rightStrand.length() != 0)
            throw new IllegalArgumentException("left strand must not be empty.");

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    }

    int getHammingDistance() {
        if(leftStrand=="" && rightStrand=="")
            return 0;
        char[] leftCharArray=leftStrand.toCharArray();
        char[] rightCharArray=rightStrand.toCharArray();
        int hamming=0;
        for(int i=0;i<leftCharArray.length;i++)
        {
            if(leftCharArray[i]==rightCharArray[i])
                continue;
            hamming+=1;

        }
        return hamming;

    }

}
