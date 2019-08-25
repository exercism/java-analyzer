class Hamming {

    private int distance = 0;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() == rightStrand.length()) {
            for (int i = 0; i < rightStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    distance ++;
                }
            }
        }
        else {
            if (leftStrand.isBlank()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isBlank()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return distance;
    }

}
