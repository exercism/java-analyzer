

class Hamming {

    private final CharSequence leftStrand;

    private final CharSequence rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        validate();
    }

    int getHammingDistance() {
        int differenceCount = 0;

        for (int currentIndex = 0; currentIndex < leftStrand.length(); currentIndex++) {
            if (leftStrand.charAt(currentIndex) != rightStrand.charAt(currentIndex)) {
                differenceCount++;
            }
        }

        return differenceCount;
    }

    private void validate() {
        if (leftStrand.length() == 0 && rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.length() == 0 && leftStrand.length() != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }
}
