class Hamming {

    String leftStrand = "";
    String rightStrand = "";

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException{
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        int diff = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

}
