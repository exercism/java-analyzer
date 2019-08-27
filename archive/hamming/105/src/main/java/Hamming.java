class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if("".equals(leftStrand) && !"".equals(rightStrand)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if("".equals(rightStrand) && !"".equals(leftStrand)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int strLength = leftStrand.length();
        char[] leftCharArr = leftStrand.toCharArray();
        char[] rightCharArr = rightStrand.toCharArray();
        int result = 0;

        for(int i=0; i<strLength; i++) {
            if(leftCharArr[i] != rightCharArr[i]) {
                result++;
            }
        }
        return result;
    }

}
