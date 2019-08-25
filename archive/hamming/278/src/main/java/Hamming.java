
class Hamming {

    private static String leftStrand;
    private static String rightStrand;
    private static int lLength;
    private static int rLength;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if(leftStrand == null || rightStrand == null) {
            throw new IllegalArgumentException("Strands cannot be null.");
        }

        if(leftStrand.isEmpty() && !rightStrand.equals("")) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(rightStrand.isEmpty() && !leftStrand.equals("")) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        lLength = leftStrand.length();
        rLength = rightStrand.length();

        if(lLength != rLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {

        int lIndex = 0;
        int rIndex = 0;
        int diffCount = 0;

        if(leftStrand.equals("") && rightStrand.equals("")) {
            return 0;
        }

        while(lIndex < lLength && rIndex < rLength) {
            if(leftStrand.charAt(lIndex++) != rightStrand.charAt(rIndex++)) {
                diffCount++;
            }
        }

        return diffCount;

    }

}
