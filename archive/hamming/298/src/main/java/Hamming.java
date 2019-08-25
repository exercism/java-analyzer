class Hamming {

    private String leftStrand;

    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == rightStrand.length()) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
        else {
            String message = "leftStrand and rightStrand must be of equal length.";
            if(leftStrand.isEmpty()) {
                message = "left strand must not be empty.";
            }
            else if(rightStrand.isEmpty()) {
                message = "right strand must not be empty.";
            }
            throw new IllegalArgumentException(message);
        }
    }

    int getHammingDistance() {
        char[] tempLeftStrand = this.leftStrand.toCharArray();
        char[] tempRightStrand = this.rightStrand.toCharArray();
        int distance = 0;
        for(int i = 0; i < tempLeftStrand.length; i++) {
            if(tempLeftStrand[i] != tempRightStrand[i]) {
                distance++;
            }
        }
        return distance;
    }


}
