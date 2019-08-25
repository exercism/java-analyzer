class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public String getLeftStrand() {
        return leftStrand;
    }

    int getHammingDistance() {
        int distance = 0;

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        for (int i = 0; i < leftStrand.length(); i++) {
            if ( !(leftStrand.charAt(i) == rightStrand.charAt(i)) ) {
                distance++;
            }
        }

        return distance;
    }
}