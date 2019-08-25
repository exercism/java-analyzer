class Hamming {

    private char[] leftStrand;
    private char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length()){
            if (leftStrand.isEmpty()){
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.isEmpty()){
                    throw new IllegalArgumentException("right strand must not be empty.");
                } else {
                    throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
                }
            }


        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {

        int distance = 0;

        for (int i = 0; i < leftStrand.length; i++) {
            if (leftStrand[i] != rightStrand[i]) {
                distance++;
            }
        }
        return distance;

    }
}

