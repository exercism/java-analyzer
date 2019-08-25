
class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int counter = 0;
        if (leftStrand.length() > rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else if (leftStrand.length() < rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else if (leftStrand.isEmpty() && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty() && leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    counter++;
                }
            }
            return counter;
        }
    }

}
