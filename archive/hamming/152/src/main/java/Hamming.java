class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (!leftStrand.equals("") || !rightStrand.equals("")) {
            if (leftStrand.equals(""))
                throw new IllegalArgumentException("left strand must not be empty.");
            else if (rightStrand.equals(""))
                throw new IllegalArgumentException("right strand must not be empty.");
            else if (leftStrand.length() != rightStrand.length()) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            } else {
                this.leftStrand = leftStrand;
                this.rightStrand = rightStrand;
            }
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }


    int getHammingDistance() throws IllegalArgumentException {

        int hammingDistance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                hammingDistance++;
        }

        return hammingDistance;
    }

}


