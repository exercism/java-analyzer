class Hamming {
    private char[] leftStrand;
    private char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == 0 && rightStrand.length() > 0) throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.length() == 0 && leftStrand.length() > 0) throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() != rightStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int distance = 0;
        for (int position = 0; position < leftStrand.length; position++) {
            if(leftStrand[position] != rightStrand[position]) distance++;
        }
        return distance;
    }

}
