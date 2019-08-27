class Hamming {

    private int HammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {

        if ((leftStrand.length() == 0) && (rightStrand.length() != 0)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if ((leftStrand.length() != 0) && (rightStrand.length() == 0)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        char[] leftStrandArray = leftStrand.toCharArray();
        char[] rightStrandArray = rightStrand.toCharArray();

        for (int i = 0; i < leftStrand.length(); i++) {
            leftStrandArray[i] = leftStrand.charAt(i);
        }
        for (int k = 0; k < leftStrand.length(); k++) {
            rightStrandArray[k] = leftStrand.charAt(k);
        }

        for (int j = 0; j < leftStrand.length(); j++) {
            if (!(leftStrandArray[j] == rightStrandArray[j])) {
                HammingDistance += 1;
            }

        }

    }

    int getHammingDistance() {
        return this.HammingDistance;
    }

}
