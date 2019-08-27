class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        int leftLen = leftStrand.length();
        int rightLen = rightStrand.length();
        
        if (leftLen == 0 && rightLen > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        
        if (rightLen == 0 && leftLen > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftLen != rightLen) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand; 
    }

    int getHammingDistance() {
        int distance = 0;
        int len = this.leftStrand.length();

        for (int i = 0; i < len; i++) {
            if (this.rightStrand.charAt(i) != this.leftStrand.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
