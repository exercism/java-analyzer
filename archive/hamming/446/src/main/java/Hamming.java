class Hamming {
    String leftStrand;
    String rightStrand;
    int countDistance;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }

    }

    int getHammingDistance() {

        char[] leftStrandArr = leftStrand.toCharArray();
        char[] rightStrandArr = rightStrand.toCharArray();

        for (int i = 0; i < leftStrandArr.length; i++) {
            if (leftStrandArr[i] != rightStrandArr[i]) {
                countDistance ++;
            }
        }
        return countDistance;
    }

}
