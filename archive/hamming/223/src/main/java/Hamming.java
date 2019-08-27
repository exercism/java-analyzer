class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;


        if (leftStrand.length() != rightStrand.length() || rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else if (rightStrand == null || leftStrand == null) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
    }

    int getHammingDistance() {
        char[] chars1 = leftStrand.toCharArray();
        char[] chars2 = rightStrand.toCharArray();
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[i]) {
                count++;
            }
        }
        return count;
    }

}
