class Hamming {

    private static final String notEqualMsg = "leftStrand and rightStrand must be of equal length.";
    private static final String notEmptyMsg = "%s must not be empty.";
    private String leftStrand;
    private String rightStrand;
    private int hammingDistance;


    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {

        if (leftStrand.length() != rightStrand.length()) {

            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException(String.format(notEmptyMsg, "left strand"));
            } else if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException(String.format(notEmptyMsg, "right strand"));
            } else throw new IllegalArgumentException(notEqualMsg);
        } else {

            this.leftStrand = leftStrand.toUpperCase();
            this.rightStrand = rightStrand.toUpperCase();

            if (this.leftStrand.equals(this.rightStrand)) {
                hammingDistance = 0;
            } else {
                for (int i = 0; i < leftStrand.length(); i++) {
                    if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                        hammingDistance++;
                    }
                }
            }
        }


    }

    int getHammingDistance() {

        return hammingDistance;

    }

    String getLeftStrand() {
        return leftStrand;
    }

    String getRightStrand() {
        return rightStrand;
    }

}
