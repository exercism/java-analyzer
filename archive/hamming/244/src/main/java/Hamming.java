class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(rightStrand.isBlank() && !leftStrand.isBlank()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.isBlank() && !rightStrand.isBlank()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        var mismatches = 0;
        for (int i = 0; i < leftStrand.length(); i++){
            if (!positionMatches(i)){
                mismatches++;
            }
        }
        return mismatches;
    }

    private boolean positionMatches(int i) {
        return leftStrand.charAt(i) == rightStrand.charAt(i);
    }

}
