class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()){
            if("".equals(leftStrand)){
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if("".equals(rightStrand)){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

}
