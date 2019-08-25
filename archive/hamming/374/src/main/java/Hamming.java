class Hamming {

    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
            if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        String[] leftStrandSplit = leftStrand.split("");
        String[] rightStrandSplit = rightStrand.split("");
        int i = 0, differences = 0;
        while(i < leftStrandSplit.length) {
            if (!leftStrandSplit[i].equals(rightStrandSplit[i])) {
                differences++;
            }
            i++;
        }
        return differences;
    }

}
