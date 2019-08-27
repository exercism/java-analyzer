import java.util.Iterator;

class Hamming {

    private String leftStrand;
    private String rightStrand;
    private int distance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throwCustomizedException(leftStrand.length(), rightStrand.length());
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.distance = 0;
    }

    int getHammingDistance() {
        Iterator<Integer> leftStrandIterator = leftStrand.chars().iterator(), rightStrandIterator = rightStrand.chars().iterator();

        while(leftStrandIterator.hasNext() && rightStrandIterator.hasNext()) {
            if(!leftStrandIterator.next().equals(rightStrandIterator.next()))
            {
                distance++;
            }
        }

        return distance;
    }

    private void throwCustomizedException(int leftStrandLength, int rightStrandLength) {

        if(leftStrandLength == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if(rightStrandLength == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
}
