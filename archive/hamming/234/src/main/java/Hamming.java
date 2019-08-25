class Hamming {

    private final String leftStrand;

    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;

        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        if (leftStrand.equals(rightStrand)) return 0;

        int distanceSum = 0;
        byte[] leftStrandBytes = leftStrand.getBytes();
        byte[] rightStrandBytes = rightStrand.getBytes();

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrandBytes[i] != rightStrandBytes[i]) distanceSum++;
        }

        return distanceSum;
    }
}
