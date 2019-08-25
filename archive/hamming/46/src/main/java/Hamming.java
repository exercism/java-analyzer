class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new UnsupportedOperationException("Strings not the same length");
        }
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new UnsupportedOperationException("String cannot be empty");
        }
        if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
            throw new UnsupportedOperationException("String cannot be empty");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i=0; i<this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance++; 
            }
        }
        return distance;
    }

}
