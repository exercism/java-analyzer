class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String theLeftStrand, String theRightStrand) throws IllegalArgumentException {
        if (theLeftStrand.length() != theRightStrand.length()) {
            throw new IllegalArgumentException(getExceptionMessage(theLeftStrand, theRightStrand));
        }

        leftStrand = theLeftStrand;
        rightStrand = theRightStrand;
    }

    static String getExceptionMessage(String theLeftStrand, String theRightStrand) {
        if (theLeftStrand.isEmpty()) {
            return "left strand must not be empty.";
        }

        if (theRightStrand.isEmpty()) {
            return "right strand must not be empty.";
        }

        return "leftStrand and rightStrand must be of equal length.";
    }

    int getHammingDistance() {
        int distance = 0;

        for(int i=0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                distance++;
        }

        return distance;
    }

}
