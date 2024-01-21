class Hamming {

    private int HammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        HammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    private int calculateHammingDistance(String leftStrand, String rightStrand) {
        int distance = 0;

        if (leftStrand.length() == rightStrand.length()) {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    distance++;
                }
            }
        } else if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        return distance;
    }

    int getHammingDistance() {
        return HammingDistance;
    }

}
