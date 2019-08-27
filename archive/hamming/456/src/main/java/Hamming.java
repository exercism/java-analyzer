import java.text.StringCharacterIterator;

class Hamming {

    private int hammingDistance = 0;
    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.length() == 0)
                throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        var leftIterator = new StringCharacterIterator(leftStrand);
        var rightIterator = new StringCharacterIterator(rightStrand);
        char leftCh, rightCh;
        for (leftCh = leftIterator.first(), rightCh = rightIterator.first(); leftCh != leftIterator.DONE; leftCh = leftIterator.next(), rightCh = rightIterator.next())
        {
            if (leftCh != rightCh)
                hammingDistance++;
        }
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}
