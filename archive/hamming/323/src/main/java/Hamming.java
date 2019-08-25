class Hamming {
	String leftStrand, rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        if (leftStrand.length() == 0 && rightStrand.length() == 0) {
            return 0;
        }

        if (leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                count++;
            }
        }

        return count;
    }

}
