class Hamming {

    private int distance = 0;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() == 0 || rightStrand.length() == 0) // check if right or left strand are empty
            throw new IllegalArgumentException(
                    String.format("%s strand must not be empty.", rightStrand.length() == 0 ? "right" : "left"));
        else if (leftStrand.length() != rightStrand.length()) // check for same length
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        // count the haming distance
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                this.distance++;
        }
    }

    // return the distance
    int getHammingDistance() {
        return this.distance;
    }

}
