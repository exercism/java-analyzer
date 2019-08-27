import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class Hamming {

    protected String leftStrand;
    protected String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        int leftStrandLength = leftStrand.length();
        int rightStrandLength = rightStrand.length();
        if (leftStrandLength == 0 && rightStrandLength != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (leftStrandLength != 0 && rightStrandLength == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrandLength != rightStrandLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int hammingDistance = 0;
        CharacterIterator leftIterator = new StringCharacterIterator(this.leftStrand);
        CharacterIterator rightIterator = new StringCharacterIterator(this.rightStrand);
        while(leftIterator.current() != CharacterIterator.DONE) {
            if (leftIterator.current() != rightIterator.current()) {
                ++hammingDistance;
            }
            leftIterator.next();
            rightIterator.next();
        }
        return hammingDistance;
    }

}
