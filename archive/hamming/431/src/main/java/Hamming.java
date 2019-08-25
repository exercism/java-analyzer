class Hamming {
    private int hammingDistance = 0;
    private String leftStrand,rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        //check if strings are empty
        if(leftStrand.isEmpty()&&rightStrand.isEmpty()){
            hammingDistance = 0;
        }
        else {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
        //check if strands are the same length
        if(rightStrand.length()!=leftStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistance++;
            }
        }

        return hammingDistance;
    }
}