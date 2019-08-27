class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == 0 && rightStrand.length() > 0){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(leftStrand.length() > 0 && rightStrand.length() == 0){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for(int i = 0; i < this.leftStrand.length(); i++) {
            if(this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

}
